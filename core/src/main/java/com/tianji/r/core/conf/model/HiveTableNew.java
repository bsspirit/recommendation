package com.tianji.r.core.conf.model;

import java.util.ArrayList;
import java.util.List;

import com.tianji.r.core.util.HiveSource;

public class HiveTableNew {

    private HiveSource hiveSource;
    private String tableName;
    private String from = "DATABASE";// DATABASE,HDFS
    private String loadWay = "OVERRIDE";
    private List<String> createHQLs;
    private List<String> dropHQLs;
    private DBTableNew dbTable;
    private HdfsPathNew hdfsPath;

    public HdfsPathNew getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(HdfsPathNew hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public HiveSource getHiveSource() {
        return hiveSource;
    }

    public void setHiveSource(HiveSource hiveSource) {
        this.hiveSource = hiveSource;
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

    public List<String> getCreateHQLs() {
        return createHQLs == null ? new ArrayList<String>() : createHQLs;
    }

    public void setCreateHQLs(List<String> createHQLs) {
        this.createHQLs = createHQLs;
    }

    public List<String> getDropHQLs() {
        return dropHQLs == null ? new ArrayList<String>() : dropHQLs;
    }

    public void setDropHQLs(List<String> dropHQLs) {
        this.dropHQLs = dropHQLs;
    }

    public DBTableNew getDbTable() {
        return dbTable;
    }

    public void setDbTable(DBTableNew dbTable) {
        this.dbTable = dbTable;
    }

}
