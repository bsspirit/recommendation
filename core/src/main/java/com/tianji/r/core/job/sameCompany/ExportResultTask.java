package com.tianji.r.core.job.sameCompany;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.ExportMySQLService;
import com.tianji.r.core.etl.ImportMySQLService;

//@Service
public class ExportResultTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    @Autowired
    DataSource alDataSource;
    @Autowired
    ExportMySQLService exportMySQLService;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("7: Export Result Task");

        return RepeatStatus.FINISHED;
    }
}
