package com.tianji.r.core.job;

import org.apache.log4j.Logger;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.tianji.r.core.main.ApplicationMain;

@Service
public class SchedulerMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(SchedulerMain.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    public static void main(String[] args) throws Exception {
        args = new String[1];
        args[0] = "/r/qa/spring-scheduler.xml";
        ApplicationContext ctx = getContext(args);
        SchedulerMain main = ctx.getBean(SchedulerMain.class);
        main.runner();
        //main.exit();
    }

    @Override
    public void runner() {// job runner
        log.info("RUNNER: PymkMain");
        // try {
        // Job job = (Job) PymkMain.getContext().getBean("pymkJob");
        // JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
        // jobLauncher.run(job, params);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }

    @Async
    @Scheduled(fixedDelay = 1000 * 1000)
    public void run1() {
        log.info("run1");
    }

    @Scheduled(fixedRate = 2000 * 1000)
    public void run2() {
        log.info("run2");
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void run3() {
        log.info("run3");
    }

}
