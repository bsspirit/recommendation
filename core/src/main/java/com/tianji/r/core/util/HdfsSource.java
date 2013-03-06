package com.tianji.r.core.util;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class HdfsSource {

    private List<String> resourceFiles;
    private SSHConnection rSSHConnection;
    private String hdfsPath;

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public List<String> getResourceFiles() {
        return resourceFiles;
    }

    public void setResourceFiles(List<String> resourceFiles) {
        this.resourceFiles = resourceFiles;
    }

    public SSHConnection getrSSHConnection() {
        return rSSHConnection;
    }

    public void setrSSHConnection(SSHConnection rSSHConnection) {
        this.rSSHConnection = rSSHConnection;
    }

}
