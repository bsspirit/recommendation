package com.tianji.r.core.job.task;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
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
import com.tianji.r.core.etl.SCPService;
import com.tianji.r.core.etl.TransformMySQLService;

@Service
public class DBTableImportTask implements Tasklet {

    private static final Logger log = Logger.getLogger(DBTableImportTask.class);

    @Autowired
    DatabaseImportCommand databaseImportCommand;
    @Autowired
    TransformMySQLService transformMySQLService;
    @Autowired
    SCPService sCPService;

    List<DatabaseJobConf> dbSyncConfList;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: DB Table Import Task");
        for (DatabaseJobConf jobConf : dbSyncConfList) {
            uploadFile(jobConf);

            DBTableNew table = jobConf.getDbTable();
            newTableProcess(table);
            String localFile = table.getLocalFile() == null ? jobConf.getLocalFilePath() : table.getLocalFile();
            importDataProcess(table, localFile);
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
                sCPService.setSCPConnection(inTransport.getConection());
                sCPService.put(localFile, remoteFolder);
            } else {// HTTP //TODO HTTP protocol

            }
        }
    }

    private void newTableProcess(DBTableNew table) throws SQLException {
        String way = table.getLoadWay();
        way = way == null ? "APPEND" : way.toUpperCase();
        log.info("ImportTableWay: " + way);
        if (way.equalsIgnoreCase("OVERRIDE")) {
            transformMySQLService.setDataSource(table.getDataSource());
            transformMySQLService.addSqlList(table.getDropSQLs());
            transformMySQLService.addSqlList(table.getCreateSQLs());
            transformMySQLService.exec();
        } else if (way.equalsIgnoreCase("update")) {// TODO next version
        } else {// append
        }
    }

    public void setDbSyncConfList(List<DatabaseJobConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }

    private void importDataProcess(DBTableNew table, String localFile) throws SQLException {
        databaseImportCommand.setDataSource(table.getDataSource());
        databaseImportCommand.setInput(localFile);
        databaseImportCommand.setTable(table.getTableName());
        databaseImportCommand.exec();
    }
}