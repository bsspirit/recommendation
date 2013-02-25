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
import com.tianji.r.core.conf.model.OutFileDBTable;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.ExportMySQLService;

@Service
public class ExportCSVTask implements TaskConf<DatabaseJobConf>, DatabaseTransport, Tasklet {

    private static final Logger log = Logger.getLogger(ExportCSVTask.class);

    @Autowired
    ExportMySQLService exportMySQLService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Export CSV Task");
        exportMySQLService.exec();
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        // String output = jobConf.getRemoteExportFilePath();
        // String sql = jobConf.getRemoteExportSQL();

        OutFileDBTable table = jobConf.getOutFileTable();
        exportMySQLService.setOutput(table.getFilePath());
        exportMySQLService.setSQL(table.getSql());
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) {
        exportMySQLService.setDataSource(dataSource);
    }

}
