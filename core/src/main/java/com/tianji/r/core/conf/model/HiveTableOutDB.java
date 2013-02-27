package com.tianji.r.core.conf.model;

public class HiveTableOutDB {

    private HiveTableNew hiveTable;
    private DBTableNew dbTable;
    private String loadWay = "OVERRIDE";

    public HiveTableNew getHiveTable() {
        return hiveTable;
    }

    public void setHiveTable(HiveTableNew hiveTable) {
        this.hiveTable = hiveTable;
    }

    public String getLoadWay() {
        return loadWay;
    }

    public void setLoadWay(String loadWay) {
        this.loadWay = loadWay;
    }

    public DBTableNew getDbTable() {
        return dbTable;
    }

    public void setDbTable(DBTableNew dbTable) {
        this.dbTable = dbTable;
    }

}
