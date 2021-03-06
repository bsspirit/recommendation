package com.tianji.r.core.job.task;

import java.io.IOException;
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

import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.conf.model.HiveTableNew;
import com.tianji.r.core.conf.model.HiveTableOutDB;
import com.tianji.r.core.etl.DatabaseSQLCommand;
import com.tianji.r.core.etl.HiveExportCommand;

@Service
public class HiveExportTask implements Tasklet {

    private static final Logger log = Logger.getLogger(HiveExportTask.class);
    @Autowired
    HiveExportCommand hiveExportCommand;
    @Autowired
    DatabaseSQLCommand databaseSQLCommand;

    List<HiveTableOutDB> hiveExportList;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        log.info("TASK: Hive Export Task");
        for (HiveTableOutDB out : hiveExportList) {
            DBTableNew dbTable = out.getDbTable();
            databaseSQLCommand.execDBTable(dbTable);
            transformDataProcess(dbTable, out.getHiveTable());
        }
        return RepeatStatus.FINISHED;
    }

    public void setHiveExportList(List<HiveTableOutDB> hiveExportList) {
        this.hiveExportList = hiveExportList;
    }

    private void transformDataProcess(DBTableNew dbTable, HiveTableNew hiveTable) throws SQLException, IOException {
        BasicDataSource dataSource = dbTable.getDataSource();
        StringBuilder sb = new StringBuilder();
        sb.append("sqoop export");
        sb.append(" --connect ").append(dataSource.getUrl().substring(0, dataSource.getUrl().indexOf("?")));
        sb.append(" -m ").append(1);
        sb.append(" --username ").append(dataSource.getUsername());
        sb.append(" --password ").append(dataSource.getPassword());
        sb.append(" --table ").append(dbTable.getTableName());
        sb.append(" --export-dir ").append("/user/hive/warehouse/").append(hiveTable.getTableName());
        sb.append(" --input-fields-terminated-by '\t'");
        // log.info(sb.toString());
        hiveExportCommand.setHiveSource(hiveTable.getHiveSource());
        hiveExportCommand.exec(sb.toString());
    }

}
