package com.tianji.r.core.etl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.DatabaseService;

//@Service
public class ExportMySQLService implements ETLCommand {

    private static final Logger log = Logger.getLogger(ExportMySQLService.class);
    private String output;
    private String script;

    @Autowired
    DatabaseService databaseService;

    public void setDataSource(DataSource dataSource) {
        databaseService.setDataSource(dataSource);
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setSQL(String sql) {
        StringBuilder sb = new StringBuilder();
        sb.append(sql + " ");
        sb.append(" into outfile '" + output + "' ");
        sb.append(" fields terminated by ',' optionally enclosed by '\"' escaped by '\"' ");
        sb.append(" lines terminated by \'\\r\\n\'; ");
        this.script = sb.toString();
    }

    /**
     * run export commend
     * 
     * @throws SQLException
     */
    public void exec() throws SQLException {
        databaseService.execute(this.script);
    }

    @Override
    public void setDataSource(BasicDataSource dataSource) throws SQLException {
        // TODO Auto-generated method stub
        
    }

}
