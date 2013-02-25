package com.tianji.r.core.job.pymk;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.core.main.ApplicationMain;

@Service
public class PymkDbSyncMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(PymkDbSyncMain.class);

    @Autowired
    SimpleJobLauncher jobLauncher;
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = getContext("/r/qa/pymk/spring-job-dbsync.xml");
        PymkDbSyncMain main = ctx.getBean(PymkDbSyncMain.class);
        main.runner();
        main.exit();
    }

    @Override
    public void runner() {
        log.info("RUNNER: PymkDbSyncMain");
        try {
            Job job = (Job) AddressBookMain.getContext().getBean("dbSyncJob");
            JobParameters params = new JobParametersBuilder().addString("task", "DbSyncJob").toJobParameters();
            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//try {
//for (DbSyncConf conf : dbSyncConfList) {
//  Job job = (Job) DbSyncMain.getContext().getBean("dbSyncJob");
////  exportCSVTask.setDbSyncConf(conf);
////  exportCSVTask.setDataSource(DbSyncMain.getContext().getBean(conf.getRemoteExportDataSource(), DataSource.class));
////
////  scpGetCSVTask.setDbSyncConf(conf);
////  scpGetCSVTask.setsCPConnection(DbSyncMain.getContext().getBean(conf.getRemoteExportSCPConection(), SCPConnection.class));
////
////  importIntoDBTask.setDbSyncConf(conf);
////  importIntoDBTask.setDataSource(DbSyncMain.getContext().getBean(conf.getLocalImportDataSource(), DataSource.class));
//
//  JobParameters params = new JobParametersBuilder().addString("task", conf.getTaskName()).toJobParameters();
//  jobLauncher.run(job, params);
//}
//} catch (Exception e) {
//e.printStackTrace();
//}


//public void setDbSyncConfList(List<DbSyncConf> dbSyncConfList) {
//this.dbSyncConfList = dbSyncConfList;
//}
//

//private List<DbSyncConf> dbSyncConfList;
//private static final Logger log = Logger.getLogger(DbSyncMain.class);
//private static ApplicationContext ctx = null;

//
//@Autowired
//SimpleJobLauncher jobLauncher;
//@Autowired
//ExportCSVTask exportCSVTask;
//@Autowired
//ScpGetCSVTask scpGetCSVTask;
//@Autowired
//ImportIntoDBTask importIntoDBTask;
//
//private DbSyncMain() {
//}
//
//public static ApplicationContext getContext() {
//if (ctx == null) {
//ctx = new ClassPathXmlApplicationContext("/r/qa/spring.xml");
//}
//return ctx;
//}
//
//public static void main(String[] args) throws Exception {
//DbSyncMain main = DbSyncMain.getContext().getBean("dbSyncMain", DbSyncMain.class);
//main.runner();
//}
//
//public void runner() throws Exception {
//log.info("=============START DbSync TASK=============");
//for (DbSyncConf conf : dbSyncConfList) {
//Job job = (Job) DbSyncMain.getContext().getBean("dbSyncJob");
//exportCSVTask.setDbSyncConf(conf);
//exportCSVTask.setDataSource(DbSyncMain.getContext().getBean(conf.getRemoteExportDataSource(), DataSource.class));
//
//scpGetCSVTask.setDbSyncConf(conf);
//scpGetCSVTask.setsCPConnection(DbSyncMain.getContext().getBean(conf.getRemoteExportSCPConection(), SCPConnection.class));
//
//importIntoDBTask.setDbSyncConf(conf);
//importIntoDBTask.setDataSource(DbSyncMain.getContext().getBean(conf.getLocalImportDataSource(), DataSource.class));
//
//JobParameters params = new JobParametersBuilder().addString("task", conf.getTaskName()).toJobParameters();
//jobLauncher.run(job, params);
//}
//}
//
