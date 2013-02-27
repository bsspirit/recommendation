package com.tianji.r.core.conf.model;

import com.tianji.r.core.util.HdfsSource;

public class HdfsPathNew {

    private String loadWay = "OVERRIDE";
    private String path;
    private HdfsSource hdfsSource;
    private DBTableNew dbTable;

    public String getLoadWay() {
        return loadWay;
    }

    public void setLoadWay(String loadWay) {
        this.loadWay = loadWay;
    }

    public String getPath() {
        return path;
    }

    public String getStorePath() {
        return "/user/hdfs/" + path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HdfsSource getHdfsSource() {
        return hdfsSource;
    }

    public void setHdfsSource(HdfsSource hdfsSource) {
        this.hdfsSource = hdfsSource;
    }

    public DBTableNew getDbTable() {
        return dbTable;
    }

    public void setDbTable(DBTableNew dbTable) {
        this.dbTable = dbTable;
    }

}
