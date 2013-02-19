package com.tianji.r.core.job.sameCompany;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

//@Service
public class SameCompanyMain {

    //private static final Logger log = Logger.getLogger(ImportMySQLService.class);

    private static ApplicationContext ctx = null;

    private SameCompanyMain() {
    }

    public static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext("spring.xml");
        }
        return ctx;
    }

    public static void main(String[] args) throws Exception {
        // Map<String, JobParameter> map = new LinkedHashMap<String, JobParameter>();

        SameCompanyMain.init();
        SimpleJobLauncher launcher = (SimpleJobLauncher) SameCompanyMain.getContext().getBean("jobLauncher");
        launcher.run((Job) SameCompanyMain.getContext().getBean("sameCompany"), new JobParameters());
    }

    private static SameCompanyJobConf conf = new SameCompanyJobConf();
    public static void init() {
        conf.setrExportFile("export_" + System.currentTimeMillis() + ".csv");
        conf.setrExportFilePath("/tmp/" + conf.getrExportFile());
        conf.setrExportSQL("SELECT * FROM t_user");
        conf.setlFolder("D:/workspace/java/tianji-recommmendation/metadata/data/");
        conf.setrDBTable("t_user");
        
        
        String sql1 = "TRUNCATE TABLE t_user2";
        String sql2 = "INSERT INTO t_user2 SELECT distinct uid FROM t_user";
        conf.getSqlists().add(sql1);
        conf.getSqlists().add(sql2);
    }

    public static SameCompanyJobConf getConf() {
        return conf;
    }

}
