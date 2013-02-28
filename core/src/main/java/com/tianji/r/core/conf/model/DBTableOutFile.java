package com.tianji.r.core.conf.model;

import org.apache.commons.dbcp.BasicDataSource;

public class DBTableOutFile {

    private String fileName;
    private String folder;
    private String sql;
    private BasicDataSource dataSource;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = "export_" + System.currentTimeMillis() + "_" + fileName;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFilePath() {
        return folder + fileName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public BasicDataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

}
