package com.tianji.r.core.job.task;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.DatabaseJobConfList;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.conf.model.OutFileDBTable;
import com.tianji.r.core.etl.ExportMySQLService;

@Service
public class DBTableExportListTask implements TaskConf<DatabaseJobConfList>, Tasklet {

    private static final Logger log = Logger.getLogger(DBTableExportListTask.class);

    @Autowired
    ExportMySQLService exportMySQLService;

    DatabaseJobConfList jobConf;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Export CSV Task");
        for (DatabaseJobConf conf : jobConf.getDbSyncConfList()) {
            OutFileDBTable table = conf.getOutFileTable();
            exportMySQLService.setOutput(table.getFilePath());
            exportMySQLService.setSQL(table.getSql());
            exportMySQLService.setDataSource(table.getDataSource());
            exportMySQLService.exec();
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConfList jobConf) {
        this.jobConf = jobConf;
    }

}
