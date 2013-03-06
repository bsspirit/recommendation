package com.tianji.r.core.etl;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.storage.DatabaseDAO;

@Service
public class DatabaseImportCommand implements ETLCommand {

//    private static final Logger log = Logger.getLogger(DatabaseImportCommand.class);

    private String input;
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

    public void setTable(String table) {
        switch (type) {
        case MYSQL:
            setMySQL(table);
            break;
        case POSTGRESQL:
            setPostgreSQL(table);
            break;
        case ORACLE:
            setOracle(table);
            break;
        default:
            // nothing
            break;
        }
    }

    @Override
    public void setMySQL(String table) {
        StringBuilder sb = new StringBuilder();
        sb.append(" LOAD DATA LOW_PRIORITY LOCAL INFILE '" + input + "' ");
        // sb.append(" REPLACE");
        sb.append(" INTO TABLE " + table + " ");
        sb.append(" FIELDS TERMINATED BY ',' ENCLOSED BY '\"' ESCAPED BY '\"' ");
        sb.append(" LINES TERMINATED BY \'\\n\'; ");// \\r
        this.script = sb.toString();
    }

    @Override
    public void setPostgreSQL(String table) {
        StringBuilder sb = new StringBuilder();
        sb.append("COPY ").append(table);
        sb.append(" FROM ").append("'" + input + "' ");
        sb.append(" WITH ");
        sb.append(" DELIMITER ',' ");
        sb.append(" CSV");
        sb.append(" NULL '' ");
        sb.append(" QUOTE '\"' ");
        sb.append(" ESCAPE '\"' ");
        sb.append(" ENCODING 'utf8' ");
        this.script = sb.toString();
    }

    @Override
    public void exec() throws SQLException {
        databaseDAO.execute(this.script);
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public void setOracle(String sql) {
        // TODO NEXT VERSION
    }

    /**
     * Wrapper function
     */
    public void execDBTable(DBTableNew table, String localFile) throws SQLException {
        setDataSource(table.getDataSource());
        setInput(localFile);
        setTable(table.getTableName());
        exec();
    }

}
