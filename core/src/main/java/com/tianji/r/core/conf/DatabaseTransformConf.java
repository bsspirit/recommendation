package com.tianji.r.core.conf;

import java.util.List;

import javax.sql.DataSource;

import com.tianji.r.core.conf.model.DBTableNew;

public class DatabaseTransformConf extends JobConf {

    private DBTableNew dbTable;// import table
    private DataSource dataSource;
    private List<String> sqls;

    public DBTableNew getDbTable() {
        return dbTable;
    }

    public void setDbTable(DBTableNew dbTable) {
        this.dbTable = dbTable;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getSqls() {
        return sqls;
    }

    public void setSqls(List<String> sqls) {
        this.sqls = sqls;
    }

}
