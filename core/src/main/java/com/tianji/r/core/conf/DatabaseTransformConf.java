package com.tianji.r.core.conf;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import com.tianji.r.core.conf.model.DBTableNew;

public class DatabaseTransformConf extends JobConf {

    private DBTableNew dbTable;// import table
    private BasicDataSource dataSource;
    private List<String> sqls;

    public DBTableNew getDbTable() {
        return dbTable;
    }

    public void setDbTable(DBTableNew dbTable) {
        this.dbTable = dbTable;
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> getSqls() {
        return sqls;
    }

    public void setSqls(List<String> sqls) {
        this.sqls = sqls;
    }

}
