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
public class ImportIntoHiveTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    @Autowired
    DataSource alDataSource;
    @Autowired
    ExportMySQLService exportMySQLService;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("5: Import Into Hive Task");

        // String output = "/tmp/export.csv";
        // String sql = "select * from t_user";
        //
        // exportMySQLService.setDataSource(alDataSource);
        // exportMySQLService.setOutput(output);
        // exportMySQLService.setSQL(sql);
        // exportMySQLService.exec();
        //
        // chunkContext.getStepContext()
        // .getStepExecution()
        // .getJobExecution()
        // .getExecutionContext();
        // //.put("value", "foo");
        return RepeatStatus.FINISHED;
    }
}
