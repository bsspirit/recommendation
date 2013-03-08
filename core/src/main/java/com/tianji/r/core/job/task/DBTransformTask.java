package com.tianji.r.core.job.task;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseTransformConf;
import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.etl.DatabaseSQLCommand;

@Service
public class DBTransformTask implements Tasklet {

    private static final Logger log = Logger.getLogger(DBTransformTask.class);

    @Autowired
    DatabaseSQLCommand databaseSQLCommand;

    DatabaseTransformConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Database Transform Data Task");
        newTableProcess(jobConf.getDbTable());
        transformDataProcess();
        return RepeatStatus.FINISHED;
    }

    public void setJobConf(DatabaseTransformConf jobConf) {
        this.jobConf = jobConf;
    }

    private void newTableProcess(DBTableNew table) throws SQLException {
        if (table == null) {
            return;
        }

        String way = table.getLoadWay();
        way = way == null ? "APPEND" : way.toUpperCase();
        log.info("ImportTableWay: " + way);
        if (way.equalsIgnoreCase("OVERRIDE")) {
            databaseSQLCommand.setDataSource(table.getDataSource());
            databaseSQLCommand.addSqlList(table.getDropSQLs());
            databaseSQLCommand.addSqlList(table.getCreateSQLs());
            databaseSQLCommand.exec();
        } else if (way.equalsIgnoreCase("update")) {// TODO next version
        } else {// append
        }
    }

    private void transformDataProcess() throws SQLException {
        databaseSQLCommand.setDataSource(jobConf.getDataSource());
        databaseSQLCommand.addSqlList(jobConf.getSqls());
        databaseSQLCommand.exec();
    }

}
