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
import com.tianji.r.core.etl.ExportMySQLService;

@Service
public class DBTableExportTask implements Tasklet {// TaskConf<DatabaseJobConf>,

    private static final Logger log = Logger.getLogger(DBTableExportTask.class);

    @Autowired
    ExportMySQLService exportMySQLService;

    List<DatabaseJobConf> dbSyncConfList;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Export CSV Task");
        for (DatabaseJobConf jobConf : dbSyncConfList) {
            DBTableOutFile table = jobConf.getOutFileTable();
            exportMySQLService.setDataSource(table.getDataSource());
            exportMySQLService.setOutput(table.getFilePath());
            exportMySQLService.setSQL(table.getSql());
            exportMySQLService.exec();
        }
        return RepeatStatus.FINISHED;
    }

    public void setDbSyncConfList(List<DatabaseJobConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }

    // @Override
    // public void setJobConf(DatabaseJobConf jobConf) {
    // this.jobConf = jobConf;
    // }

}
