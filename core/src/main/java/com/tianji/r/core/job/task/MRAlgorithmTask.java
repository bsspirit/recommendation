package com.tianji.r.core.job.task;

import org.apache.hadoop.mapred.JobConf;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.HdfsJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.etl.HdfsTransport;
import com.tianji.r.core.storage.MapReduceService;
import com.tianji.r.core.util.HdfsSource;

@Service
public class MRAlgorithmTask implements Tasklet, HdfsTransport, TaskConf<HdfsJobConf> {

    private static final Logger log = Logger.getLogger(MRAlgorithmTask.class);

    @Autowired
    MapReduceService mapRecudeService;

    HdfsJobConf jobConf;
    HdfsSource hdfsSource;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: MapReduce Algorithm Task - " + jobConf.getMapReduceClass());
        JobConf conf = mapRecudeService.createJobConf(jobConf.getMapReduceClazz());
        conf.setOutputKeyClass(jobConf.getOutputKeyClazz());
        conf.setOutputValueClass(jobConf.getOutputValueClazz());

        conf.setMapperClass(jobConf.getMapperClazz());
        conf.setReducerClass(jobConf.getReducerClazz());

        mapRecudeService.setInputPath(jobConf.getInputPath());
        mapRecudeService.setOutputPath(jobConf.getOutputPath());
        mapRecudeService.exec();

        return RepeatStatus.FINISHED;
    }

    @Override
    public void setJobConf(HdfsJobConf jobConf) {
        this.jobConf = jobConf;
    }

    @Override
    public void setHdfsSource(HdfsSource hdfsSource) {
        mapRecudeService.setHdfsSource(hdfsSource);
    }

}
