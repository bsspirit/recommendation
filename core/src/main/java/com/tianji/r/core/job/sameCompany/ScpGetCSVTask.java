package com.tianji.r.core.job.sameCompany;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.SCPService;
import com.tianji.r.core.util.SCPConnection;

//@Service
public class ScpGetCSVTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    @Autowired
    SCPConnection alSCPConnection;
    @Autowired
    SCPConnection deskSCPConnection;
    @Autowired
    SCPService sCPService;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("2: SCP Get CSV Task");

        String remotePath = SameCompanyMain.getConf().getrExportFilePath();
        String localFolder = SameCompanyMain.getConf().getlFolder();
        sCPService.setSCPConnection(alSCPConnection);
        sCPService.get(remotePath, localFolder);
        return RepeatStatus.FINISHED;
    }
}
