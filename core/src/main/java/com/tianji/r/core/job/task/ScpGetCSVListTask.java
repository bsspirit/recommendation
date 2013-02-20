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
import com.tianji.r.core.etl.SCPService;

@Service
public class ScpGetCSVListTask implements TaskConf<DatabaseJobConfList>, Tasklet {

    private static final Logger log = Logger.getLogger(ScpGetCSVListTask.class);

    @Autowired
    SCPService sCPService;

    DatabaseJobConfList jobConf;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: SCP Get CSV Task");
        for (DatabaseJobConf conf : jobConf.getDbSyncConfList()) {
            String remotePath = conf.getRemoteExportFilePath();
            String localFolder = conf.getLocalFolder();
            sCPService.setSCPConnection(conf.getRemoteExportSCPConection());
            sCPService.get(remotePath, localFolder);
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConfList jobConf) {
        this.jobConf = jobConf;
    }

}