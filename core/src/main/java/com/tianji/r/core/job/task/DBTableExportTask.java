package com.tianji.r.core.job.task;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.conf.model.DBTableOutFile;
import com.tianji.r.core.etl.ExportMySQLService;

@Service
public class DBTableExportTask implements TaskConf<DatabaseJobConf>, Tasklet {

    private static final Logger log = Logger.getLogger(DBTableExportTask.class);

    @Autowired
    ExportMySQLService exportMySQLService;

    DatabaseJobConf jobConf;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Export CSV Task");
        DBTableOutFile table = jobConf.getOutFileTable();
        exportMySQLService.setDataSource(table.getDataSource());
        exportMySQLService.setOutput(table.getFilePath());
        exportMySQLService.setSQL(table.getSql());
        exportMySQLService.exec();
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        this.jobConf = jobConf;
    }

}
