package com.tianji.r.core.job.task;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.HiveAlgorithmConf;
import com.tianji.r.core.conf.model.HiveTableNew;
import com.tianji.r.core.storage.HiveDAO;

@Service
public class HiveAlgorithmTask implements Tasklet {// TaskConf<HiveAlgorithmConf>

    private static final Logger log = Logger.getLogger(HiveAlgorithmTask.class);

    @Autowired
    HiveDAO hiveDAO;

    List<HiveAlgorithmConf> hiveAlgorithmConfList;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Hive Algorithm Task");

        for (HiveAlgorithmConf jobConf : hiveAlgorithmConfList) {
            hiveDAO.setHiveTemplate(jobConf.getHiveTemplate());
            newTableProcess(jobConf.getHiveTable());
            transformDataProcess(jobConf);
        }
        return RepeatStatus.FINISHED;
    }

    public void setHiveAlgorithmConfList(List<HiveAlgorithmConf> hiveAlgorithmConfList) {
        this.hiveAlgorithmConfList = hiveAlgorithmConfList;
    }

    private void newTableProcess(HiveTableNew table) throws SQLException {
        for (String hql : table.getDropHQLs()) {
            List<String> list = hiveDAO.query(hql);
            log.info(list);
        }
        for (String hql : table.getCreateHQLs()) {
            List<String> list = hiveDAO.query(hql);
            log.info(list);
        }
    }

    private void transformDataProcess(HiveAlgorithmConf jobConf) throws SQLException {
        for (String query : jobConf.getHqls()) {
            List<String> list = hiveDAO.query(query);
            log.info(list);
        }
    }

}
