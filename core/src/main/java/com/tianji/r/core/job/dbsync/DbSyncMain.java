package com.tianji.r.core.job.dbsync;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.core.util.SCPConnection;

//@Service
public class DbSyncMain {

    private static final Logger log = Logger.getLogger(DbSyncMain.class);
    private static ApplicationContext ctx = null;
    private List<DbSyncConf> dbSyncConfList;

    @Autowired
    SimpleJobLauncher jobLauncher;
    @Autowired
    ExportCSVTask exportCSVTask;
    @Autowired
    ScpGetCSVTask scpGetCSVTask;
    @Autowired
    ImportIntoDBTask importIntoDBTask;

    private DbSyncMain() {
    }

    public static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext("/r/qa/spring.xml");
        }
        return ctx;
    }

    public static void main(String[] args) throws Exception {
        DbSyncMain main = DbSyncMain.getContext().getBean("dbSyncMain", DbSyncMain.class);
        main.runner();
    }

    public void runner() throws Exception {
        log.info("=============START DbSync TASK=============");
        for (DbSyncConf conf : dbSyncConfList) {
            Job job = (Job) DbSyncMain.getContext().getBean("dbSyncJob");
            exportCSVTask.setDbSyncConf(conf);
            exportCSVTask.setDataSource(DbSyncMain.getContext().getBean(conf.getRemoteExportDataSource(), DataSource.class));

            scpGetCSVTask.setDbSyncConf(conf);
            scpGetCSVTask.setsCPConnection(DbSyncMain.getContext().getBean(conf.getRemoteExportSCPConection(), SCPConnection.class));

            importIntoDBTask.setDbSyncConf(conf);
            importIntoDBTask.setDataSource(DbSyncMain.getContext().getBean(conf.getLocalImportDataSource(), DataSource.class));

            JobParameters params = new JobParametersBuilder().addString("task", conf.getTaskName()).toJobParameters();
            jobLauncher.run(job, params);
        }
    }

    public void setDbSyncConfList(List<DbSyncConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }

}
