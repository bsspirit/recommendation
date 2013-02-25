package com.tianji.r.core.job.task;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.JobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.TransformMySQLService;

@Service
public class TransformDataTask implements Tasklet, DatabaseTransport, TaskConf<DatabaseJobConf> {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    @Autowired
    TransformMySQLService transformMySQLService;

    DataSource dataSource;
    DatabaseJobConf jobConf;

    //TODO TransformDataTask
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Database Transform Data Task");
        transformMySQLService.setDataSource(dataSource);
        //transformMySQLService.addSqlList(jobConf.getTransformSQLList());
        transformMySQLService.exec();
        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(DatabaseJobConf jobConf) {
        this.jobConf = jobConf;
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

}
