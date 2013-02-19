package com.tianji.r.core.conf;

import java.util.List;

public class HiveJobConf extends JobConf {

    private List<String> importIntoHiveTables;
    private List<String> hiveQuerys;
    private List<String> exportHiveTable;
    private List<String> exportResultTable;

    public List<String> getExportHiveTable() {
        return exportHiveTable;
    }

    public void setExportHiveTable(List<String> exportHiveTable) {
        this.exportHiveTable = exportHiveTable;
    }

    public List<String> getExportResultTable() {
        return exportResultTable;
    }

    public void setExportResultTable(List<String> exportResultTable) {
        this.exportResultTable = exportResultTable;
    }

    public List<String> getHiveQuerys() {
        return hiveQuerys;
    }

    public void setHiveQuerys(List<String> hiveQuerys) {
        this.hiveQuerys = hiveQuerys;
    }

    public List<String> getImportIntoHiveTables() {
        return importIntoHiveTables;
    }

    public void setImportIntoHiveTables(List<String> importIntoHiveTables) {
        this.importIntoHiveTables = importIntoHiveTables;
    }

}
