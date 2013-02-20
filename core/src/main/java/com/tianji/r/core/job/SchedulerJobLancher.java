package com.tianji.r.core.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerJobLancher {

    @Autowired
    private JobLauncher jobLauncher;
    
    private Job job;

    public void launch() throws Exception {
        JobParameters params = new JobParametersBuilder().addString("job", job.getName()).toJobParameters();
        jobLauncher.run(job, params);
    }

    public void setJob(Job job) {
        this.job = job;
    }

}
