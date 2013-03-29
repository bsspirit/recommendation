package com.tianji.r.core.job.task;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.model.DBTableOutFile;
import com.tianji.r.core.etl.DatabaseExportCommand;

@Service
public class DBTableExportTask implements Tasklet {

    private static final Logger log = Logger.getLogger(DBTableExportTask.class);

    @Autowired
    DatabaseExportCommand databaseExportCommand;

    List<DatabaseJobConf> dbSyncConfList;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Export CSV Task");
        for (DatabaseJobConf jobConf : dbSyncConfList) {
            DBTableOutFile table = jobConf.getOutFileTable();
            databaseExportCommand.execDBTable(table);
        }
        return RepeatStatus.FINISHED;
    }

    public void setDbSyncConfList(List<DatabaseJobConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }

}
