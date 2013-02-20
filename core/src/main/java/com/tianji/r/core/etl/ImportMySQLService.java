package com.tianji.r.core.etl;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.DatabaseService;

@Service
public class ImportMySQLService implements ETLCommand {

    private static final Logger log = Logger.getLogger(ImportMySQLService.class);
    private String input;
    private String script;

    @Autowired
    DatabaseService databaseService;

    public void setInput(String input) {
        this.input = input;
    }

    public void setDataSource(DataSource dataSource) {
        databaseService.setDataSource(dataSource);
    }

    @Override
    public void exec() throws SQLException {
        databaseService.execute(this.script);
    }

    public void setTable(String table) {
        StringBuilder sb = new StringBuilder();
        sb.append(" LOAD DATA LOW_PRIORITY LOCAL INFILE '" + input + "' ");
        // sb.append(" REPLACE");
        sb.append(" INTO TABLE " + table + " ");
        sb.append(" FIELDS TERMINATED BY ',' ENCLOSED BY '\"' ESCAPED BY '\"' ");
        sb.append(" LINES TERMINATED BY \'\\r\\n\'; ");
        this.script = sb.toString();
    }

}
