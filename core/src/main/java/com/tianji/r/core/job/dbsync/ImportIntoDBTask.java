package com.tianji.r.core.job.dbsync;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.job.AbstrackTasklet;

@Service
public class ImportIntoDBTask extends AbstrackTasklet implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportIntoDBTask.class);

    @Autowired
    ImportMySQLService importMySQLService;

    DataSource dataSource;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("3: Import Into DB Task");

        String dbFile = dbSyncConf.getLocalFilePath();
        String table = dbSyncConf.getLocalImportTable();

        importMySQLService.setDataSource(dataSource);
        importMySQLService.setInput(dbFile);
        importMySQLService.setTable(table);
        importMySQLService.exec();
        return RepeatStatus.FINISHED;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}