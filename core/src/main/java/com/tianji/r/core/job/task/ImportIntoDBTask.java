package com.tianji.r.core.job.task;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.ImportMySQLService;

@Service
public class ImportIntoDBTask implements TaskConf<DatabaseJobConf>, DatabaseTransport, Tasklet {

    private static final Logger log = Logger.getLogger(ImportIntoDBTask.class);

    @Autowired
    ImportMySQLService importMySQLService;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Import Into DB Task");
        importMySQLService.exec();
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        String dbFile = jobConf.getLocalFilePath();
        String table = jobConf.getLocalImportTable();
        importMySQLService.setInput(dbFile);
        importMySQLService.setTable(table);
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) {
        importMySQLService.setDataSource(dataSource);
    }
}