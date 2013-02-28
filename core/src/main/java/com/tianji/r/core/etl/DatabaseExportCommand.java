package com.tianji.r.core.etl;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.DatabaseService;

@Service
public class DatabaseExportCommand implements ETLCommand {
    
    public enum DatabaseType {
        MYSQL, POSTGRESQL
    };

    private static final Logger log = Logger.getLogger(DatabaseExportCommand.class);

    private String output;
    private String script;
    private DatabaseType type;

    @Autowired
    DatabaseService databaseService;

    @Override
    public void setDataSource(BasicDataSource dataSource) throws SQLException {
        String driver = dataSource.getDriverClassName();
        if (driver.contains("mysql")) {
            type = DatabaseType.MYSQL;
        } else if (driver.contains("postgresql")) {
            type = DatabaseType.POSTGRESQL;
        } else {
            throw new SQLException("Error Database Driver Configurition ==>" + driver);
        }
        databaseService.setDataSource(dataSource);
    }

    @Override
    public void exec() throws SQLException {
        databaseService.execute(this.script);
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public void setSQL(String sql) {
        switch (type) {
        case MYSQL:
            setMySQL(sql);
            break;
        case POSTGRESQL:
            setPostgreSQL(sql);
            break;
        }
    }

    private void setMySQL(String sql) {
        StringBuilder sb = new StringBuilder();
        sb.append(sql.trim());
        sb.append(" INTO OUTFILE '" + output + "' ");
        sb.append(" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' ESCAPED BY '\"' ");
        sb.append(" LINES TERMINATED BY \'\\r\\n\'; ");
        this.script = sb.toString();
    }

    private void setPostgreSQL(String sql) {
        StringBuilder sb = new StringBuilder();
        sb.append("COPY (").append(sql.trim()).append(") ");
        sb.append(" TO ").append("'" + output + "' ");
        sb.append(" WITH ");
        sb.append(" DELIMITER ',' ");
        sb.append(" CSV");
        sb.append(" NULL '\\r\\n' ");
//        sb.append(" QUOTE '\"' ");
//        sb.append(" ESCAPE '\"' ");
//        sb.append(" ENCODING 'utf8'");
        this.script = sb.toString();
    }

}
