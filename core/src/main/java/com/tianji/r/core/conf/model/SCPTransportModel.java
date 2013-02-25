package com.tianji.r.core.conf.model;

import com.tianji.r.core.util.SCPConnection;

public class SCPTransportModel {

    private String remoteFile;
    private String localFolder;
    private SCPConnection conection;

    public String getRemoteFile() {
        return remoteFile;
    }

    public void setRemoteFile(String remoteFile) {
        this.remoteFile = remoteFile;
    }

    public String getLocalFolder() {
        return localFolder;
    }

    public void setLocalFolder(String localFolder) {
        this.localFolder = localFolder;
    }

    public SCPConnection getConection() {
        return conection;
    }

    public void setConection(SCPConnection conection) {
        this.conection = conection;
    }

}
