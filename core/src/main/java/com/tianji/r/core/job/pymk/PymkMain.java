package com.tianji.r.core.job.pymk;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.ApplicationMain;

@Service
public class PymkMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(PymkMain.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    public static void main(String[] args) throws Exception {
        args = new String[3];
        args[0] = "/r/qa/pymk/spring-job-pymk.xml";
        args[1] = "/r/qa/pymk/spring-job-addressBook.xml";
        args[2] = "/r/qa/pymk/spring-job-dbsync.xml";
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
            JobParameters params = new JobParametersBuilder().addString("task", "PYMK").toJobParameters();
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
