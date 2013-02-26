package com.tianji.r.core.conf;

import java.util.List;

import com.tianji.r.core.conf.model.HiveTableNew;

public class HiveJobConf extends JobConf {

    private List<HiveTableNew> hiveNewList;

    public List<HiveTableNew> getHiveNewList() {
        return hiveNewList;
    }

    public void setHiveNewList(List<HiveTableNew> hiveNewList) {
        this.hiveNewList = hiveNewList;
    }

    // private List<String> importIntoHiveTables;
    // private List<String> hiveQuerys;
    // private List<String> exportHiveTable;
    // private List<String> exportResultTable;
    //
    // private String exportResultTableWay;
    // private List<String> exportResultTableCreateSQL;
    // private List<String> exportResultTableDropSQL;
    //
    // public String getExportResultTableWay() {
    // return exportResultTableWay;
    // }
    //
    // public void setExportResultTableWay(String exportResultTableWay) {
    // this.exportResultTableWay = exportResultTableWay;
    // }
    //
    // public List<String> getExportResultTableCreateSQL() {
    // return exportResultTableCreateSQL;
    // }
    //
    // public void setExportResultTableCreateSQL(List<String> exportResultTableCreateSQL) {
    // this.exportResultTableCreateSQL = exportResultTableCreateSQL;
    // }
    //
    // public List<String> getExportResultTableDropSQL() {
    // return exportResultTableDropSQL;
    // }
    //
    // public void setExportResultTableDropSQL(List<String> exportResultTableDropSQL) {
    // this.exportResultTableDropSQL = exportResultTableDropSQL;
    // }
    //
    // public List<String> getExportHiveTable() {
    // return exportHiveTable;
    // }
    //
    // public void setExportHiveTable(List<String> exportHiveTable) {
    // this.exportHiveTable = exportHiveTable;
    // }
    //
    // public List<String> getExportResultTable() {
    // return exportResultTable;
    // }
    //
    // public void setExportResultTable(List<String> exportResultTable) {
    // this.exportResultTable = exportResultTable;
    // }
    //
    // public List<String> getHiveQuerys() {
    // return hiveQuerys;
    // }
    //
    // public void setHiveQuerys(List<String> hiveQuerys) {
    // this.hiveQuerys = hiveQuerys;
    // }
    //
    // public List<String> getImportIntoHiveTables() {
    // return importIntoHiveTables;
    // }
    //
    // public void setImportIntoHiveTables(List<String> importIntoHiveTables) {
    // this.importIntoHiveTables = importIntoHiveTables;
    // }

}
