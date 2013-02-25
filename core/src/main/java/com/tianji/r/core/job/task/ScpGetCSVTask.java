package com.tianji.r.core.job.task;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.conf.model.SCPTransportModel;
import com.tianji.r.core.etl.SCPService;

@Service
public class ScpGetCSVTask implements TaskConf<DatabaseJobConf>, Tasklet {

    private static final Logger log = Logger.getLogger(ScpGetCSVTask.class);

    @Autowired
    SCPService sCPService;

    // SCPConnection sCPConnection;
    DatabaseJobConf jobConf;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: SCP Get CSV Task");
        // String remotePath = jobConf.getRemoteExportFilePath();
        // String localFolder = jobConf.getLocalFolder();
        // sCPService.setSCPConnection(sCPConnection);
        // sCPService.get(remotePath, localFolder);

        SCPTransportModel transport = jobConf.getTransport();
        String remoteFile = transport.getRemoteFile();
        if (remoteFile == null) {
            remoteFile = jobConf.getRemoteFilePath();
        }

        sCPService.setSCPConnection(transport.getConection());
        sCPService.get(remoteFile, transport.getLocalFolder());
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        this.jobConf = jobConf;
    }

    // @Override
    // public void setsCPConnection(SCPConnection sCPConnection) {
    // this.sCPConnection = sCPConnection;
    // }

}