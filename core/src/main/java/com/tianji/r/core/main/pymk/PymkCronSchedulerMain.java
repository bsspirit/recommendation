package com.tianji.r.core.main.pymk;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.core.main.ApplicationMain;

@Service
public class PymkCronSchedulerMain extends ApplicationMain {

    private static final Logger log = Logger.getLogger(PymkCronSchedulerMain.class);

    public static void main(String[] args) throws Exception {
        args = new String[14];
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
        args[13] = "/r/qa/pymk/spring-job-pymk-scheduler.xml";
        ApplicationContext ctx = getContext(args);
        PymkCronSchedulerMain main = ctx.getBean(PymkCronSchedulerMain.class);
        main.runner();
    }

    @Override
    protected void runner() {
        log.info("runner");
    }

}
