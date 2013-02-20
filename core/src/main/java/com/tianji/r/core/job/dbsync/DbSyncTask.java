package com.tianji.r.core.job.dbsync;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.util.SCPConnection;

//@Service
public class DbSyncTask implements Tasklet {

    private static final Logger log = Logger.getLogger(DbSyncTask.class);
    private List<DbSyncConf> dbSyncConfList;

    @Autowired
    SimpleJobLauncher jobLauncher;
    @Autowired
    ExportCSVTask exportCSVTask;
    @Autowired
    ScpGetCSVTask scpGetCSVTask;
    @Autowired
    ImportIntoDBTask importIntoDBTask;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("===========================================");
        log.info("=============START DbSync TASK=============");
        log.info("===========================================");

        Job job = (Job) DbSyncMain.getContext().getBean("dbSyncJob");
        for (DbSyncConf conf : dbSyncConfList) {
            exportCSVTask.setDbSyncConf(conf);
            exportCSVTask.setDataSource((DataSource) DbSyncMain.getContext().getBean("qaDataSource"));

            scpGetCSVTask.setDbSyncConf(conf);
            scpGetCSVTask.setsCPConnection((SCPConnection) DbSyncMain.getContext().getBean("qaSCPConnection"));

            importIntoDBTask.setDbSyncConf(conf);
            importIntoDBTask.setDataSource((DataSource) DbSyncMain.getContext().getBean("deskDataSource"));

            jobLauncher.run(job, new JobParameters());
        }
        return RepeatStatus.FINISHED;
    }

    public void setDbSyncConfList(List<DbSyncConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }

}
