package com.tianji.r.core.job.addressBook;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.stereotype.Service;

import com.tianji.r.core.algorithm.HiveAlgorithm;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.storage.HiveService;

//@Service
public class AddressBookHiveAlgorithmTask implements Tasklet, HiveAlgorithm, TaskConf<AddressBookJobConf> {

    private static final Logger log = Logger.getLogger(AddressBookHiveAlgorithmTask.class);

    @Autowired
    HiveService hiveService;

    HiveTemplate hiveTemplate;
    AddressBookJobConf jobConf;

    @Override
    public void setJobConf(AddressBookJobConf jobConf) {
        this.jobConf = jobConf;
    }

    @Override
    public void setHiveTemplate(HiveTemplate hiveTemplate) {
        hiveService.setHiveTemplate(hiveTemplate);
    }

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        for (String query : jobConf.getHiveQuerys()) {
            log.info(query);
            List<String> list = hiveService.query(query);
            log.info(list);
        }
        return RepeatStatus.FINISHED;
    }
}
