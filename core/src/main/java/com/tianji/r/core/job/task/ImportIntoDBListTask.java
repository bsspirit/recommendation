package com.tianji.r.core.job.task;

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
import com.tianji.r.core.etl.ImportMySQLService;

@Service
public class ImportIntoDBListTask implements TaskConf<DatabaseJobConfList>, Tasklet {

    private static final Logger log = Logger.getLogger(ImportIntoDBListTask.class);

    @Autowired
    ImportMySQLService importMySQLService;
    DatabaseJobConfList jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Import Into DB Task");
        for (DatabaseJobConf conf : jobConf.getDbSyncConfList()) {
            importMySQLService.setInput(conf.getLocalFilePath());
            importMySQLService.setTable(conf.getLocalImportTable());
            importMySQLService.setDataSource(conf.getLocalImportDataSource());
            importMySQLService.exec();
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConfList jobConf) {
        this.jobConf = jobConf;
    }
}