package com.tianji.r.core.conf.model;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

public class DBTableNew {

    private BasicDataSource dataSource;// dbcp pool
    private String tableName;
    private String loadWay;
    private List<String> createSQLs;
    private List<String> dropSQLs;
    private String localFile;

    public String getLocalFile() {
        return localFile;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getLoadWay() {
        return loadWay;
    }

    public void setLoadWay(String loadWay) {
        this.loadWay = loadWay;
    }

    public List<String> getCreateSQLs() {
        return createSQLs;
    }

    public void setCreateSQLs(List<String> createSQLs) {
        this.createSQLs = createSQLs;
    }

    public List<String> getDropSQLs() {
        return dropSQLs;
    }

    public void setDropSQLs(List<String> dropSQLs) {
        this.dropSQLs = dropSQLs;
    }

}
