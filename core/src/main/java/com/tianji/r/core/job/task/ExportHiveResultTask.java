package com.tianji.r.core.job.task;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.HiveJobConf;
import com.tianji.r.core.conf.TaskConf;
import com.tianji.r.core.etl.DatabaseTransport;
import com.tianji.r.core.etl.ExportHiveService;
import com.tianji.r.core.etl.HiveTransport;
import com.tianji.r.core.etl.TransformMySQLService;
import com.tianji.r.core.storage.DatabaseService;
import com.tianji.r.core.util.HiveSource;

@Service
public class ExportHiveResultTask implements Tasklet, HiveTransport, DatabaseTransport, TaskConf<HiveJobConf> {

    private static final Logger log = Logger.getLogger(ExportHiveResultTask.class);
    @Autowired
    ExportHiveService exportHiveService;
//    @Autowired
//    DatabaseService databaseService;
    @Autowired
    TransformMySQLService transformMySQLService;

    BasicDataSource dataSource;
    HiveSource hiveSource;
    HiveJobConf jobConf;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Export Hive Result Task");

//        List<String> hiveTables = jobConf.getExportHiveTable();
//        List<String> resultTables = jobConf.getExportResultTable();
//
//        if (hiveTables == null || resultTables == null)
//            throw new Exception("ExportHiveTable property is empty!!");
//        
//        importTableWay(jobConf);
//
//        for (int i = 0; i < hiveTables.size(); i++) {
//            // clear output table
//            // databaseService.execute("TRUNCATE TABLE " + resultTables.get(i));
//
//            StringBuilder sb = new StringBuilder();
//            sb.append(" sqoop export ");
//            sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
//            sb.append(" -m ").append(1);
//            sb.append(" --username ").append(dataSource.getUsername());
//            sb.append(" --password ").append(dataSource.getPassword());
//            sb.append(" --table ").append(resultTables.get(i));
//            sb.append(" --export-dir ").append("/user/hive/warehouse/").append(hiveTables.get(i));
//            sb.append(" --input-fields-terminated-by '\t'");
//            // log.info(sb.toString());
//            exportHiveService.exec(sb.toString());
//        }
        return RepeatStatus.FINISHED;
    }
    
    private void importTableWay(HiveJobConf conf) throws SQLException {
//        String way = conf.getExportResultTableWay();
//        way = way == null ? "OVERRIDE" : way.toUpperCase();
//        log.info("ImportTableWay: " + way);
//        if (way.equalsIgnoreCase("APPEND")) {
//        } else if (way.equalsIgnoreCase("update")) {// TODO next version
//        } else {// OVERRIDE
//            transformMySQLService.setDataSource(dataSource);
//            transformMySQLService.addSqlList(conf.getExportResultTableDropSQL());
//            transformMySQLService.addSqlList(conf.getExportResultTableCreateSQL());
//            transformMySQLService.exec();
//        }
    }


    @Override
    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
//        databaseService.setDataSource(dataSource);
    }

    @Override
    public void setHiveSource(HiveSource hiveSource) {
        exportHiveService.setHiveSource(hiveSource);
    }

    @Override
    public void setJobConf(HiveJobConf jobConf) {
        this.jobConf = jobConf;
    }

}
