package com.tianji.r.core.job.task;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.HdfsJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.HdfsTransport;
import com.tianji.r.core.etl.ImportHdfsService;
import com.tianji.r.core.util.HdfsSource;

@Service
public class ImportIntoHdfsTask implements Tasklet, HdfsTransport, DatabaseTransport, TaskConf<HdfsJobConf> {

    private static final Logger log = Logger.getLogger(ImportIntoHdfsTask.class);

    @Autowired
    ImportHdfsService importHdfsService;

    BasicDataSource dataSource;
    HdfsSource hdfsSource;
    HdfsJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Import Into HDFS Task");

        for (String table : jobConf.getImportIntoHdfsTables()) {
            String target = "/user/hdfs/" + table;
            importHdfsService.exec("hadoop fs -rmr " + target);

            StringBuilder sb = new StringBuilder();
            sb.append(" sqoop import ");
            sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
            sb.append(" --username ").append(dataSource.getUsername());
            sb.append(" --password ").append(dataSource.getPassword());
            sb.append(" --table ").append(table);
            // if(column!=null) sb.append(" --columns").append(column);
            sb.append(" -m 4");
            sb.append(" --target-dir ").append(target);
            // sb.append(" --append");
            // sb.append(" --fields-terminated-by '\t'");
            // log.info(sb.toString());
            importHdfsService.exec(sb.toString());
        }
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void setJobConf(HdfsJobConf jobConf) {
        this.jobConf = jobConf;
    }

    @Override
    public void setHdfsSource(HdfsSource hdfsSource) {
        importHdfsService.setHdfsSource(hdfsSource);
    }

}
