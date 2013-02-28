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
public class SameSchoolMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(SameSchoolMain.class);

    @Autowired
    SimpleJobLauncher jobLauncher;

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = getContext(
                "/r/qa/pymk/spring-job-sameSchool.xml",
                "/r/qa/pymk/spring-job-db-import-table.xml",
                "/r/qa/pymk/spring-job-hive-table.xml");
        SameSchoolMain main = ctx.getBean(SameSchoolMain.class);
        main.runner();
        main.exit();
    }

    @Override
    public void runner() {
        log.info("RUNNER: SameSchoolMain");
        try {
            Job job = (Job) SameSchoolMain.getContext().getBean("sameSchool_MapRedJob");
            JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
            jobLauncher.run(job, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
