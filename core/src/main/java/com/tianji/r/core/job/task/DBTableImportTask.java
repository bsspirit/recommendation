package com.tianji.r.core.job.task;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.conf.model.SCPTransportModel;
import com.tianji.r.core.etl.DatabaseImportCommand;
import com.tianji.r.core.etl.DatabaseSQLCommand;
import com.tianji.r.core.storage.ScpDAO;

@Service
public class DBTableImportTask implements Tasklet {

    private static final Logger log = Logger.getLogger(DBTableImportTask.class);

    @Autowired
    DatabaseImportCommand databaseImportCommand;
    @Autowired
    DatabaseSQLCommand databaseSQLCommand;
    @Autowired
    ScpDAO scpDAO;

    List<DatabaseJobConf> dbSyncConfList;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: DB Table Import Task");
        for (DatabaseJobConf jobConf : dbSyncConfList) {
            uploadFile(jobConf);
            DBTableNew table = jobConf.getDbTable();
            databaseSQLCommand.execDBTable(table);
            String localFile = table.getLocalFile() == null ? jobConf.getLocalFilePath() : table.getLocalFile();
            databaseImportCommand.execDBTable(table, localFile);
        }
        return RepeatStatus.FINISHED;
    }

    private void uploadFile(DatabaseJobConf jobConf) throws IOException {// TODO split to Task
        SCPTransportModel inTransport = jobConf.getDbTable().getTransport();
        if (inTransport != null) {
            SCPTransportModel outTransport = jobConf.getOutFileTable().getTransport();
            String localFile = outTransport.getLocalFolder() + File.separator + jobConf.getOutFileTable().getFileName();// middle store file
            String remoteFolder = jobConf.getDbTable().getFolder();// \tmp

            jobConf.getDbTable().setLocalFile(remoteFolder + jobConf.getOutFileTable().getFileName());// \tmp\xxx_12121_xxx.csv
            String protocol = inTransport.getProtocol();
            if (protocol.equalsIgnoreCase("FTP")) {// TODO FTP protocol

            } else if (protocol.equalsIgnoreCase("SCP")) {
                scpDAO.setSCPConnection(inTransport.getConection());
                scpDAO.put(localFile, remoteFolder);
            } else {// HTTP //TODO HTTP protocol

            }
        }
    }

    public void setDbSyncConfList(List<DatabaseJobConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }

}