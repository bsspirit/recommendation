package com.tianji.r.core.etl;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.DatabaseDAO;

@Service
public class DatabaseExportCommand implements ETLCommand {

    private static final Logger log = Logger.getLogger(DatabaseExportCommand.class);

    private String output;
    private String script;
    public DatabaseType type;

    @Autowired
    DatabaseDAO databaseDAO;

    @Override
    public void setDataSource(BasicDataSource dataSource) throws SQLException {
        String driver = dataSource.getDriverClassName();
        if (driver.contains("mysql")) {
            type = DatabaseType.MYSQL;
        } else if (driver.contains("postgresql")) {
            type = DatabaseType.POSTGRESQL;
        } else if (driver.contains("oracle")) {
            type = DatabaseType.ORACLE;// TODO NEXT
        } else {
            throw new SQLException("Error Database Driver Configurition ==>" + driver);
        }
        databaseDAO.setDataSource(dataSource);
    }

    @Override
    public void exec() throws SQLException {
        databaseDAO.execute(this.script);
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
        case ORACLE:
            setOracle(sql);
            break;
        default:
            // nothing
            break;
        }
    }

    @Override
    public void setMySQL(String sql) {
        StringBuilder sb = new StringBuilder();
        sb.append(sql.trim());
        sb.append(" INTO OUTFILE '" + output + "' ");
        sb.append(" FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' ESCAPED BY '\"' ");
        sb.append(" LINES TERMINATED BY \'\\n\'; "); // \\r
        this.script = sb.toString();
    }

    @Override
    public void setPostgreSQL(String sql) {
        StringBuilder sb = new StringBuilder();
        sb.append("COPY (").append(sql.trim()).append(") ");
        sb.append(" TO ").append("'" + output + "' ");
        sb.append(" WITH ");
        sb.append(" DELIMITER ',' ");
        sb.append(" CSV");
        sb.append(" NULL '' ");
        sb.append(" QUOTE '\"' ");
        sb.append(" ESCAPE '\"' ");
        sb.append(" ENCODING 'utf8' ");
        // sb.append(" FORCE QUOTE ").append("ip,create_time");
        this.script = sb.toString();
    }

    @Override
    public void setOracle(String sql) {
        // TODO NEXT VERSION
    }

}
