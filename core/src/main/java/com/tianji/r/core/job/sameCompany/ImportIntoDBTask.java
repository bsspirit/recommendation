package com.tianji.r.core.job.sameCompany;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.tianji.r.core.etl.ImportMySQLService;

//@Service
public class ImportIntoDBTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    @Autowired
    BasicDataSource deskDataSource;
    @Autowired
    ImportMySQLService importMySQLService;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("3: Import Into DB Task");

        String dbFile = SameCompanyMain.getConf().getlFolder() + SameCompanyMain.getConf().getrExportFile();
        String table = SameCompanyMain.getConf().getrDBTable();
        importMySQLService.setDataSource(deskDataSource);
        importMySQLService.setInput(dbFile);
        importMySQLService.setTable(table);
        importMySQLService.exec();
        
        return RepeatStatus.FINISHED;
    }
}
