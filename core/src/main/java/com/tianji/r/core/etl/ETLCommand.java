package com.tianji.r.core.etl;

import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public interface ETLCommand {
    
    public void exec()throws SQLException;
    public void setDataSource(BasicDataSource dataSource)throws SQLException;
    public void setMySQL(String sql);
    public void setPostgreSQL(String sql);
    public void setOracle(String sql);
    
    public enum DatabaseType {
        MYSQL, POSTGRESQL, ORACLE
    };
    
}
