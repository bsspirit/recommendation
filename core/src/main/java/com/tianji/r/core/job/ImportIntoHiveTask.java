package com.tianji.r.core.job;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.etl.ImportHiveService;
import com.tianji.r.core.job.addressBook.AddressBookJobConf;
import com.tianji.r.core.util.HiveSource;

//@Service
public class ImportIntoHiveTask implements Tasklet {

    private static final Logger log = Logger.getLogger(ImportIntoHiveTask.class);

    @Autowired
    ImportHiveService importHiveService;

    BasicDataSource dataSource;
    HiveSource hiveSource;
    AddressBookJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("5: Import Into Hive Task");
        importHiveService.setHiveSource(hiveSource);
        for (String table : jobConf.getImportIntoHiveTables()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" sqoop import ");
            sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
            sb.append(" --username ").append(dataSource.getUsername());
            sb.append(" --password ").append(dataSource.getPassword());
            sb.append(" --table ").append(table);
            sb.append(" --hive-import");
            //sb.append(" --fields-terminated-by ','");
            // log.info(sb.toString());
            importHiveService.exec(sb.toString());
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
