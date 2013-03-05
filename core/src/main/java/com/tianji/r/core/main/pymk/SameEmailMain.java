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
public class SameEmailMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(SameEmailMain.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = getContext(
                "/r/qa/pymk/spring-job-sameEmail.xml",
                "/r/qa/pymk/spring-job-db-import-table.xml",
                "/r/qa/pymk/spring-job-hive-table.xml",
                "/r/qa/pymk/spring-job-hdfs-path.xml");
        SameEmailMain main = ctx.getBean(SameEmailMain.class);
        main.runner();
        main.exit();
    }

    @Override
    public void runner() {
        log.info("RUNNER: SameEmailMain");
        try {
            Job job = (Job) SameEmailMain.getContext().getBean("sameEmail_MapRedJob");
            JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
