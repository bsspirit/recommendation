package com.tianji.r.core.job.dbsync;

public class DbSyncConf {

    private String taskName;
    private String remoteExportFile;
    private String remoteExportFolder;
    private String remoteExportFileName;
    private String remoteExportSQL;
    private String remoteExportDataSource;
    private String remoteExportSCPConection;
    private String localFolder;
    private String localImportTable;
    private String localImportDataSource;

    public String getRemoteExportSCPConection() {
        return remoteExportSCPConection;
    }

    public void setRemoteExportSCPConection(String remoteExportSCPConection) {
        this.remoteExportSCPConection = remoteExportSCPConection;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getLocalImportDataSource() {
        return localImportDataSource;
    }

    public void setLocalImportDataSource(String localImportDataSource) {
        this.localImportDataSource = localImportDataSource;
    }

    public String getRemoteExportDataSource() {
        return remoteExportDataSource;
    }

    public void setRemoteExportDataSource(String remoteExportDataSource) {
        this.remoteExportDataSource = remoteExportDataSource;
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

    public String getRemoteExportFileName() {
        return remoteExportFileName;
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

    public String getLocalFolder() {
        return localFolder;
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }

    public String getLocalFilePath() {
        return getLocalFolder() + this.remoteExportFileName;
    }

}
