package com.tianji.r.core.job.sameCompany;

import java.util.ArrayList;
import java.util.List;

import com.tianji.r.core.conf.JobConf;

public class SameCompanyJobConf extends JobConf {

    private String rExportFile; // REMOTE_EXPORT_FILE for MySQL Export File Name
    private String rExportFilePath;// REMOTE_EXPORT_FILE for MySQL Export File PATH
    private String rExportSQL;// REMOTE_EXPORT_FILE for MySQL Export Script
    private String lFolder;// LOCAL_FOLDER for storing CSV FILE
    private String rDBTable;
    private List<String> sqlists = new ArrayList<String>();
    
    public List<String> getSqlists() {
        return sqlists;
    }

    public String getrDBTable() {
        return rDBTable;
    }

    public void setrDBTable(String rDBTable) {
        this.rDBTable = rDBTable;
    }

    public String getrExportFile() {
        return rExportFile;
    }

    public void setrExportFile(String rExportFile) {
        this.rExportFile = rExportFile;
    }

    public String getrExportFilePath() {
        return rExportFilePath;
    }

    public void setrExportFilePath(String rExportFilePath) {
        this.rExportFilePath = rExportFilePath;
    }

    public String getrExportSQL() {
        return rExportSQL;
    }

    public void setrExportSQL(String rExportSQL) {
        this.rExportSQL = rExportSQL;
    }

    public String getlFolder() {
        return lFolder;
    }

    public void setlFolder(String lFolder) {
        this.lFolder = lFolder;
    }

}
