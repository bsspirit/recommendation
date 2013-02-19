package com.tianji.r.core.job.task;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.HiveJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.HiveTransport;
import com.tianji.r.core.etl.ImportHiveService;
import com.tianji.r.core.util.HiveSource;

@Service
public class ImportIntoHiveTask implements Tasklet, HiveTransport, DatabaseTransport, TaskConf<HiveJobConf> {

    private static final Logger log = Logger.getLogger(ImportIntoHiveTask.class);

    @Autowired
    ImportHiveService importHiveService;

    BasicDataSource dataSource;
    HiveSource hiveSource;
    HiveJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Import Into Hive Task");

        for (String table : jobConf.getImportIntoHiveTables()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" sqoop import ");
            sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
            sb.append(" --username ").append(dataSource.getUsername());
            sb.append(" --password ").append(dataSource.getPassword());
            sb.append(" --table ").append(table);
            sb.append(" --hive-import");
            sb.append(" --hive-overwrite");
            //sb.append(" --fields-terminated-by '\t'");
            // log.info(sb.toString());
            importHiveService.exec(sb.toString());
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setHiveSource(HiveSource hiveSource) {
        importHiveService.setHiveSource(hiveSource);
    }

    @Override
    public void setJobConf(HiveJobConf jobConf) {
        this.jobConf = jobConf;
    }

}
