package com.tianji.r.core.main.pymk;

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
public class PymkMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(PymkMain.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    public static void main(String[] args) throws Exception {
        args = new String[13];
        args[0] = "/r/qa/pymk/spring-job-pymk.xml";
        args[1] = "/r/qa/pymk/spring-job-addressBook.xml";
        args[2] = "/r/qa/pymk/spring-job-dbsync.xml";
        args[3] = "/r/qa/pymk/spring-job-db-import-table.xml";
        args[4] = "/r/qa/pymk/spring-job-db-outfile-table.xml";
        args[5] = "/r/qa/pymk/spring-job-hive-table.xml";
        args[6] = "/r/qa/pymk/spring-job-hdfs-path.xml";
        args[7] = "/r/qa/pymk/spring-job-sameCompany.xml";
        args[8] = "/r/qa/pymk/spring-job-sameSchool.xml";
        args[9] = "/r/qa/pymk/spring-job-sameIP.xml";
        args[10] = "/r/qa/pymk/spring-job-sameEmail.xml";
        args[11] = "/r/qa/pymk/spring-job-sameJob.xml";
        args[12] = "/r/qa/pymk/spring-job-mergeFilter.xml";
        ApplicationContext ctx = getContext(args);
        PymkMain main = ctx.getBean(PymkMain.class);
        main.runner();
        main.exit();
    }

    @Override
    public void runner() {// job runner
        log.info("RUNNER: PymkMain");
        try {
            Job job = (Job) PymkMain.getContext().getBean("pymkJob");
            JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TaskScheduler scheduler = PymkMain.getContext().getBean("scheduler", TaskScheduler.class);
        // scheduler.schedule(new Runnable() {
        // public void run() {
        // System.out.println(new Date());
        // }
        // }, new Date());

        // PymkDbSyncMain r1 = PymkMain.getContext().getBean("pymkDbSyncMain", PymkDbSyncMain.class);
        // r1.runner();
        // AddressBookMain r2 = PymkMain.getContext().getBean("addressBookMain", AddressBookMain.class);
        // r2.runner();
    }

    // @Async
    // @Scheduled(fixedDelay = 600*1000)
    // public void run1(){
    // System.out.println("run1");
    // }

}
