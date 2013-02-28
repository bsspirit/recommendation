package com.tianji.r.core.job.sameCompany;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.TransformMySQLService;

//@Service
public class TransformDataTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    @Autowired
    BasicDataSource deskDataSource;
    @Autowired
    TransformMySQLService transformMySQLService;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("4: Transform Data Task");
        transformMySQLService.setDataSource(deskDataSource);
        transformMySQLService.addSqlList(SameCompanyMain.getConf().getSqlists());
        transformMySQLService.exec();
        return RepeatStatus.FINISHED;
    }
}
