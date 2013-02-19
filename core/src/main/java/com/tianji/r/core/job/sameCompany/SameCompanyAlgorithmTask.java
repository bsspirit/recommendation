package com.tianji.r.core.job.sameCompany;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

//@Service
public class SameCompanyAlgorithmTask implements Tasklet {

    private static final Logger log = Logger.getLogger(SameCompanyAlgorithmTask.class);

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("6: Same Company Algorithm Task");
        return RepeatStatus.FINISHED;
    }

}
