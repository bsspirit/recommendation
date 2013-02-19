package com.tianji.r.core.job.dbsync;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.SCPService;
import com.tianji.r.core.job.AbstrackTasklet;
import com.tianji.r.core.util.SCPConnection;

@Service
public class ScpGetCSVTask extends AbstrackTasklet implements Tasklet {
    
    private static final Logger log = Logger.getLogger(ScpGetCSVTask.class);

    @Autowired
    SCPService sCPService;

    SCPConnection sCPConnection;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("2: SCP Get CSV Task");

        String remotePath = dbSyncConf.getRemoteExportFilePath();
        String localFolder = dbSyncConf.getLocalFolder();

        System.out.println(remotePath);

        sCPService.setSCPConnection(sCPConnection);
        sCPService.get(remotePath, localFolder);
        return RepeatStatus.FINISHED;
    }

    public void setsCPConnection(SCPConnection sCPConnection) {
        this.sCPConnection = sCPConnection;
    }
}