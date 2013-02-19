package com.tianji.r.core;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.common.IOUtils;
import net.schmizz.sshj.connection.channel.direct.Session.Command;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tianji.r.core.etl.ExportMySQLService;
import com.tianji.r.core.etl.ImportMySQLService;
import com.tianji.r.core.etl.SCPService;
import com.tianji.r.core.etl.TransformMySQLService;
import com.tianji.r.core.storage.DatabaseService;
import com.tianji.r.core.storage.HdfsService;
import com.tianji.r.core.storage.HiveService;
import com.tianji.r.core.util.SCPConnection;

public class SpringInitialize {

    private static ApplicationContext ctx = null;

    private SpringInitialize() {
    }

    public static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext("spring.xml");
        }
        return ctx;
    }

    public static void main(String[] args) throws Exception {
        // hdfs();
        // database();
        // mapreduce();
        // hive();
        // etl_export2();
        // scp();
        // etl_import();
        // transform();
         importHive();

//        ssh();
    }

    static void importHive() {
        // sqoop import --connect jdbc:mysql://42.121.108.236:3306/r
        // --username tianji --password tianji --table t_user
        // --hive-import --hive-table t_user
        // --warehouse-dir /user/hive/warehouse
        // --fields-terminated-by ',' --split-by id

        StringBuilder sb = new StringBuilder();
        sb.append(" sqoop import ");
        sb.append(" --connect jdbc:mysql://42.121.108.236:3306/r");
        sb.append(" --username tianji");
        sb.append(" --password tianji");
        sb.append(" --table t_user2 --hive-import");
        System.out.println(sb.toString());

    }

    static void ssh() throws IOException {
        SSHClient client = new SSHClient();
        client.loadKnownHosts();
        client.connect("192.168.1.243");
        try {
            client.authPassword("root", "Hitb");
            final net.schmizz.sshj.connection.channel.direct.Session session = client.startSession();
            try {
                // final Command cmd = session.exec("ping -c 1 google.com");
                final Command cmd = session.exec("ls");
                System.out.println(IOUtils.readFully(cmd.getInputStream()).toString());
                cmd.join(5, TimeUnit.SECONDS);
                System.out.println("\n** exit status: " + cmd.getExitStatus());
            } finally {
                session.close();
            }
        } finally {
            client.disconnect();
        }
    }

    static void exportHive() {
        // sqoop export --connect jdbc:mysql://42.121.108.236:3306/r -m 1
        // --username tianji --password tianji --table t_user_hive
        // --export-dir /user/hive/warehouse/t_user
        // --input-fields-terminated-by ','
    }

    static void transform() throws SQLException {
        DataSource ds = (DataSource) SpringInitialize.getContext().getBean("alDataSource");
        TransformMySQLService transform = (TransformMySQLService) SpringInitialize.getContext().getBean("transformMySQLService");
        transform.setDataSource(ds);

        List<String> list = new ArrayList<String>();
        String sql1 = "TRUNCATE TABLE t_user2";
        String sql2 = "INSERT INTO t_user2 SELECT distinct uid FROM t_user1";
        list.add(sql1);
        list.add(sql2);
        transform.setSqlList(list);
        transform.exec();
    }

    static void scp() throws IOException {
        SCPConnection scpConnection = (SCPConnection) SpringInitialize.getContext().getBean("alSCPConnection");
        SCPService scp = (SCPService) SpringInitialize.getContext().getBean("sCPService");
        String remoteFile = "/tmp/export.csv";
        String localFolder = "D:/workspace/java/tianji-recommmendation/metadata/data/";
        scp.setSCPConnection(scpConnection);
        scp.get(remoteFile, localFolder);
    }

    static void etl_import() throws SQLException {
        DataSource ds = (DataSource) SpringInitialize.getContext().getBean("alDataSource");
        String input = "/tmp/export.csv";
        String table = "t_user1";

        ImportMySQLService im = SpringInitialize.getContext().getBean(ImportMySQLService.class);
        im.setDataSource(ds);
        im.setInput(input);
        im.setTable(table);
        im.exec();
    }

    static void etl_export() throws SQLException {
        DataSource ds = (DataSource) SpringInitialize.getContext().getBean("r1DataSource");
        String output = "D:/workspace/java/tianji-recommmendation/metadata/data/export.csv";
        String sql = "select * from t_user";

        ExportMySQLService export = SpringInitialize.getContext().getBean(ExportMySQLService.class);
        export.setDataSource(ds);
        export.setOutput(output);
        export.setSQL(sql);
        export.exec();
    }

    static void etl_export2() throws SQLException {
        DataSource ds = (DataSource) SpringInitialize.getContext().getBean("alDataSource");
        String output = "/tmp/export.csv";
        String sql = "select * from t_user";

        ExportMySQLService export = SpringInitialize.getContext().getBean(ExportMySQLService.class);
        export.setDataSource(ds);
        export.setOutput(output);
        export.setSQL(sql);
        export.exec();
    }

    static void hive() {
        HiveService hive = SpringInitialize.getContext().getBean(HiveService.class);
        List<String> list = hive.query("show tables;");
        System.out.println(list);
        String count2 = hive.queryForString("select count(*) from t_hive;");
        System.out.println("Count ==>" + count2);
    }

    static void mapreduce() throws Exception {
        JobLauncher jobLauncher = SpringInitialize.getContext().getBean(JobLauncher.class);
        Job job = SpringInitialize.getContext().getBean(Job.class);
        Map<String, JobParameter> map = new HashMap<String, JobParameter>();
        map.put("word.input", new JobParameter("/user/conan/word/input/"));
        map.put("word.output", new JobParameter("/user/conan/word/output/"));
        jobLauncher.run(job, new JobParameters(map));

    }

    static void hdfs() throws IOException {
        HdfsService hdfs = (HdfsService) SpringInitialize.getContext().getBean("hdfsService");
        hdfs.rmr("/user/conan/word");
        hdfs.mkdirs("/user/conan/word/input");
        // hdfs.mkdirs("/user/conan/word/output");
        hdfs.copyFile("data/nietzsche-chapter-1.txt", "/user/conan/word/input");
        hdfs.ls("/user/conan/word/input");
        hdfs.download("/user/conan/word/", "data/word");
    }

    static void database() {
        DataSource ds = (DataSource) SpringInitialize.getContext().getBean("r1DataSource");
        DatabaseService o = (DatabaseService) SpringInitialize.getContext().getBean("databaseService");
        o.setDataSource(ds);
        System.out.println(o.getList("select * from t_user"));
    }

}
