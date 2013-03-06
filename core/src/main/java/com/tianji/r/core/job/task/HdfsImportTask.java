package com.tianji.r.core.job.task;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.conf.model.HdfsPathNew;
import com.tianji.r.core.etl.HdfsImportCommand;

@Service
public class HdfsImportTask implements Tasklet {// TaskConf<HdfsJobConf>

    private static final Logger log = Logger.getLogger(HdfsImportTask.class);

    @Autowired
    HdfsImportCommand hdfsImportCommand;

    List<HdfsPathNew> hdfsNewList;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: HDFS Import Task");
        for (HdfsPathNew hdfs : hdfsNewList) {
            newTableProcess(hdfs);
            importDataProcess(hdfs);
        }
        return RepeatStatus.FINISHED;
    }

    public void setHdfsNewList(List<HdfsPathNew> hdfsNewList) {
        this.hdfsNewList = hdfsNewList;
    }

    private void newTableProcess(HdfsPathNew hdfs) throws SQLException, IOException {
        hdfsImportCommand.setHdfsSource(hdfs.getHdfsSource());
        hdfsImportCommand.exec("hadoop fs -rmr " + hdfs.getStorePath());
    }

    private void importDataProcess(HdfsPathNew hdfs) throws SQLException, IOException {
        DBTableNew dbTable = hdfs.getDbTable();
        BasicDataSource dataSource = dbTable.getDataSource();
        StringBuilder sb = new StringBuilder();
        sb.append(" sqoop import ");
        sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
        sb.append(" --username ").append(dataSource.getUsername());
        sb.append(" --password ").append(dataSource.getPassword());
        sb.append(" --table ").append(dbTable.getTableName());
        // if(column!=null) sb.append(" --columns").append(column);
        sb.append(" -m 4");
        sb.append(" --target-dir ").append(hdfs.getStorePath());
        // sb.append(" --append");
        // sb.append(" --fields-terminated-by '\t'");
        // log.info(sb.toString());
        hdfsImportCommand.exec(sb.toString());
    }

}
