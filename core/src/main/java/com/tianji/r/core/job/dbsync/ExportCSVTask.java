package com.tianji.r.core.job.dbsync;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.ExportMySQLService;
import com.tianji.r.core.job.AbstrackTasklet;

@Service
public class ExportCSVTask extends AbstrackTasklet implements Tasklet {

    private static final Logger log = Logger.getLogger(ExportCSVTask.class);

    @Autowired
    ExportMySQLService exportMySQLService;
    DataSource dataSource;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("1: Export CSV Task");

        String output = dbSyncConf.getRemoteExportFilePath();
        String sql = dbSyncConf.getRemoteExportSQL();

        exportMySQLService.setDataSource(dataSource);
        exportMySQLService.setOutput(output);
        exportMySQLService.setSQL(sql);
        exportMySQLService.exec();
        
        return RepeatStatus.FINISHED;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
