package com.tianji.r.core.job.task;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.conf.model.NewDBTable;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.TransformMySQLService;

@Service
public class ImportIntoDBTask implements TaskConf<DatabaseJobConf>, DatabaseTransport, Tasklet {

    private static final Logger log = Logger.getLogger(ImportIntoDBTask.class);

    @Autowired
    ImportMySQLService importMySQLService;
    @Autowired
    TransformMySQLService transformMySQLService;

    DatabaseJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Import Into DB Task");
        importTableWay(jobConf.getDbTable());

        String dbFile = jobConf.getLocalFilePath();
        // String table = jobConf.getLocalImportTable();//TODO remove
        String table = jobConf.getDbTable().getTableName();

        importMySQLService.setInput(dbFile);
        importMySQLService.setTable(table);
        importMySQLService.exec();
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        this.jobConf = jobConf;
    }

    private void importTableWay(NewDBTable table) throws SQLException {
        // String way = conf.getLocalImportTableWay();
        String way = table.getLoadWay();

        way = way == null ? "APPEND" : way.toUpperCase();
        log.info("ImportTableWay: " + way);
        if (way.equalsIgnoreCase("OVERRIDE")) {
            // transformMySQLService.setDataSource(conf.getLocalImportDataSource());
            // transformMySQLService.addSqlList(conf.getLocalImportTableDropSQL());
            // transformMySQLService.addSqlList(conf.getLocalImportTableCreateSQL());
            transformMySQLService.setDataSource(table.getDataSource());
            transformMySQLService.addSqlList(table.getDropSQLs());
            transformMySQLService.addSqlList(table.getCreateSQLs());
            transformMySQLService.exec();
        } else if (way.equalsIgnoreCase("update")) {// TODO next version
        } else {// append
        }
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) {
        importMySQLService.setDataSource(dataSource);
    }
}