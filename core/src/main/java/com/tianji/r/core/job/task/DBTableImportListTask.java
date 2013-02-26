package com.tianji.r.core.job.task;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.DatabaseJobConfList;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.conf.model.NewDBTable;
import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.TransformMySQLService;

@Service
public class DBTableImportListTask implements TaskConf<DatabaseJobConfList>, Tasklet {

    private static final Logger log = Logger.getLogger(DBTableImportListTask.class);

    @Autowired
    ImportMySQLService importMySQLService;
    @Autowired
    TransformMySQLService transformMySQLService;

    DatabaseJobConfList jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: DB Table Import Task");
        for (DatabaseJobConf conf : jobConf.getDbSyncConfList()) {
            NewDBTable table = conf.getDbTable();
            newTableProcess(table);
            
            String localFile = table.getLocalFile()==null?conf.getLocalFilePath():table.getLocalFile();
            importDataProcess(table, localFile);
        }
        return RepeatStatus.FINISHED;
    }

    private void newTableProcess(NewDBTable table) throws SQLException {
        String way = table.getLoadWay();
        way = way == null ? "APPEND" : way.toUpperCase();
        log.info("ImportTableWay: " + way);
        if (way.equalsIgnoreCase("OVERRIDE")) {
            transformMySQLService.setDataSource(table.getDataSource());
            transformMySQLService.addSqlList(table.getDropSQLs());
            transformMySQLService.addSqlList(table.getCreateSQLs());
            transformMySQLService.exec();
        } else if (way.equalsIgnoreCase("update")) {// TODO next version
        } else {// append
        }
    }

    private void importDataProcess(NewDBTable table, String localFile) throws SQLException {
        importMySQLService.setInput(localFile);
        importMySQLService.setTable(table.getTableName());
        importMySQLService.setDataSource(table.getDataSource());
        importMySQLService.exec();
    }

    @Override
    public void setJobConf(DatabaseJobConfList jobConf) {
        this.jobConf = jobConf;
    }
}