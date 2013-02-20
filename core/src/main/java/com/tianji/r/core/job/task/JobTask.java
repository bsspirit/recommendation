package com.tianji.r.core.job.task;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.job.CommonJob;

@Service
public class JobTask implements Tasklet, CommonJob {

    private static final Logger log = Logger.getLogger(JobTask.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    Job job;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Job Task " + job.getName());
        JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
        jobLauncher.run(job, params);
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJob(Job job) {
        this.job = job;
    }

}
