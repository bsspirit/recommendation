package com.tianji.r.core.main.meta;

import java.util.ArrayList;
import java.util.List;

import org.mortbay.log.Log;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.Global;
import com.tianji.r.core.conf.MapRedAlgorithmConf;
import com.tianji.r.core.conf.meta.LoadMetaData;
import com.tianji.r.core.conf.model.HdfsPathNew;
import com.tianji.r.core.conf.model.HiveTableNew;
import com.tianji.r.core.job.task.HdfsImportTask;
import com.tianji.r.core.job.task.HiveImportTask;
import com.tianji.r.core.job.task.MapRedAlgorithmTask;
import com.tianji.r.core.main.ApplicationMain;
import com.tianji.r.core.storage.DatabaseDAO;

@Service
public class SameCompanyMain extends ApplicationMain {

    public static void main(String[] args) {
        args = new String[1];
        args[0] = "/r/biz/spring-biz.xml";

        ApplicationContext ctx = getContext(args);
        SameCompanyMain main = ctx.getBean(SameCompanyMain.class);

        main.runner();
        // main.showBeans();
        main.exit();
    }

    @Autowired
    DatabaseDAO databaseDAO;
    @Autowired
    Global global;
    @Autowired
    LoadMetaData loadMetaData;

    @Autowired
    SimpleJobLauncher jobLauncher;

    @Override
    protected void runner() {
        Log.info("RUNNER: MetaDataMAIN");
        loadMetaData.createScpSource();
        loadMetaData.createSshSource();
        loadMetaData.createHdfsSource();
        loadMetaData.createHiveSource();
        loadMetaData.createDataSource();
        loadMetaData.createTransport();
        loadMetaData.createDBTableOut();
        loadMetaData.createDBTable();
        loadMetaData.createDBTableConf();
        loadMetaData.createHdfsPath();
        loadMetaData.createHiveTable();
        loadMetaData.createMapRedAlgorithm("sameCompany_MapRedAlgorithmConf");

        try {

            // Parameters
            HdfsPathNew hdfs = global.getMeta("hdfs_o_same_company", HdfsPathNew.class);
            List<HdfsPathNew> list = new ArrayList<HdfsPathNew>();
            list.add(hdfs);
            MapRedAlgorithmConf mapRed = global.getMeta("sameCompany_MapRedAlgorithmConf", MapRedAlgorithmConf.class);
            HiveTableNew hive = global.getMeta("hive_o_same_company", HiveTableNew.class);
            List<HiveTableNew> hlist = new ArrayList<HiveTableNew>();
            hlist.add(hive);

            // TASK
            ApplicationContext ctx = getContext();
            HdfsImportTask hdfsImportTask = ctx.getBean("hdfsImportTask", HdfsImportTask.class);
            hdfsImportTask.setHdfsNewList(list);
            MapRedAlgorithmTask mapRedAlgorithmTask = ctx.getBean("mapRedAlgorithmTask", MapRedAlgorithmTask.class);
            mapRedAlgorithmTask.setJobConf(mapRed);
            HiveImportTask hiveImportTask = ctx.getBean("hiveImportTask", HiveImportTask.class);
            hiveImportTask.setHiveNewList(hlist);
            

            Job job = (Job) SameCompanyMain.getContext().getBean("sameCompany_MapRedJob");
            JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}