package com.tianji.r.core.conf;

import java.util.List;

public class JobConf {

    private String taskName;
    private String remoteExportFile;
    private String remoteExportFolder;
    private String remoteExportFileName;
    private String remoteExportSQL;
    private String localImportTable;
    private String localFolder;
    private List<String> transformSQLList;
    
    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public List<String> getTransformSQLList() {
        return transformSQLList;
    }

    public void setTransformSQLList(List<String> transformSQLList) {
        this.transformSQLList = transformSQLList;
    }

    public String getLocalFolder() {
        return localFolder;
    }

    public String getLocalFilePath() {
        return getLocalFolder() + this.remoteExportFileName;
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }

    public String getRemoteExportFilePath() {
        return getRemoteExportFolder() + this.remoteExportFileName;
    }

    public String getRemoteExportFile() {
        return remoteExportFile;
    }

    public void setRemoteExportFile(String remoteExportFile) {
        this.remoteExportFile = remoteExportFile;
        this.remoteExportFileName = "export_" + System.currentTimeMillis() + "_" + getRemoteExportFile();
    }

    public String getRemoteExportFolder() {
        return remoteExportFolder;
    }

    public void setRemoteExportFolder(String remoteExportFolder) {
        this.remoteExportFolder = remoteExportFolder;
    }

    public String getRemoteExportSQL() {
        return remoteExportSQL;
    }

    public void setRemoteExportSQL(String remoteExportSQL) {
        this.remoteExportSQL = remoteExportSQL;
    }

    public String getLocalImportTable() {
        return localImportTable;
    }

    public void setLocalImportTable(String localImportTable) {
        this.localImportTable = localImportTable;
    }

    // private String rExportFile; // REMOTE_EXPORT_FILE for MySQL Export File Name
    // private String rExportFilePath;// REMOTE_EXPORT_FILE for MySQL Export File PATH
    // private String rExportSQL;// REMOTE_EXPORT_FILE for MySQL Export Script
    // private String lFolder;// LOCAL_FOLDER for storing CSV FILE
    // private String rDBTable;
    // private List<String> sqlists = new ArrayList<String>();
    //
    // public List<String> getSqlists() {
    // return sqlists;
    // }
    //
    // public String getrDBTable() {
    // return rDBTable;
    // }
    //
    // public void setrDBTable(String rDBTable) {
    // this.rDBTable = rDBTable;
    // }
    //
    // public String getrExportFile() {
    // return rExportFile;
    // }
    //
    // public void setrExportFile(String rExportFile) {
    // this.rExportFile = rExportFile;
    // }
    //
    // public String getrExportFilePath() {
    // return rExportFilePath;
    // }
    //
    // public void setrExportFilePath(String rExportFilePath) {
    // this.rExportFilePath = rExportFilePath;
    // }
    //
    // public String getrExportSQL() {
    // return rExportSQL;
    // }
    //
    // public void setrExportSQL(String rExportSQL) {
    // this.rExportSQL = rExportSQL;
    // }
    //
    // public String getlFolder() {
    // return lFolder;
    // }
    //
    // public void setlFolder(String lFolder) {
    // this.lFolder = lFolder;
    // }

}
