package com.tianji.r.core.job;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.ExportHiveService;
import com.tianji.r.core.job.addressBook.AddressBookJobConf;
import com.tianji.r.core.storage.DatabaseService;
import com.tianji.r.core.util.HiveSource;

//@Service
public class ExportHiveResultTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ExportHiveResultTask.class);

    @Autowired
    ExportHiveService exportHiveService;

    @Autowired
    DatabaseService databaseService;

    BasicDataSource dataSource;
    HiveSource hiveSource;
    AddressBookJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("8: Export Hive Result Task");
        exportHiveService.setHiveSource(hiveSource);
        databaseService.setDataSource(dataSource);

        List<String> hiveTables = jobConf.getExportHiveTable();
        List<String> resultTables = jobConf.getExportResultTable();

        if (hiveTables == null || resultTables == null)
            throw new Exception("ExportHiveTable property is empty!!");

        for (int i = 0; i < hiveTables.size(); i++) {
            databaseService.execute("TRUNCATE TABLE " + hiveTables.get(i));
            StringBuilder sb = new StringBuilder();
            sb.append(" sqoop export ");
            sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
            sb.append(" -m ").append(1);
            sb.append(" --username ").append(dataSource.getUsername());
            sb.append(" --password ").append(dataSource.getPassword());
            sb.append(" --table ").append(resultTables.get(i));
            sb.append(" --export-dir ").append("/user/hive/warehouse/").append(hiveTables.get(i));
            sb.append(" --input-fields-terminated-by '\t'");
            // log.info(sb.toString());
            exportHiveService.exec(sb.toString());
        }
        return RepeatStatus.FINISHED;
    }

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setJobConf(AddressBookJobConf jobConf) {
        this.jobConf = jobConf;
    }

    public void setHiveSource(HiveSource hiveSource) {
        this.hiveSource = hiveSource;
    }

}
