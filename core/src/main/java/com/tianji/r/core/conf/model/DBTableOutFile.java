package com.tianji.r.core.conf.model;

import javax.sql.DataSource;

public class DBTableOutFile {

    private String fileName;
    private String folder;
    private String sql;
    private DataSource dataSource;

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

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
