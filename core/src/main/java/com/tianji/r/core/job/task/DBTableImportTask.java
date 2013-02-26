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
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.TransformMySQLService;

@Service
public class DBTableImportTask implements TaskConf<DatabaseJobConf>, Tasklet {

    private static final Logger log = Logger.getLogger(DBTableImportTask.class);

    @Autowired
    ImportMySQLService importMySQLService;
    @Autowired
    TransformMySQLService transformMySQLService;

    DatabaseJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: DB Table Import Task");
        DBTableNew table = jobConf.getDbTable();
        newTableProcess(table);
        importDataProcess(table);
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        this.jobConf = jobConf;
    }

    private void newTableProcess(DBTableNew table) throws SQLException {
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

    private void importDataProcess(DBTableNew table) throws SQLException {
        String localFile = table.getLocalFile() == null ? jobConf.getLocalFilePath() : table.getLocalFile();
        importMySQLService.setDataSource(table.getDataSource());
        importMySQLService.setInput(localFile);
        importMySQLService.setTable(table.getTableName());
        importMySQLService.exec();
    }
}