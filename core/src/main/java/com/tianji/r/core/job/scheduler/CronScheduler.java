package com.tianji.r.core.job.scheduler;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CronScheduler {

    private static final Logger log = Logger.getLogger(CronScheduler.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    Job job;

    public void launch() {
        log.info("CRON LANCH : " + job.getName());
        try {
            JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setJob(Job job) {
        this.job = job;
    }

}
