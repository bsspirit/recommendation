package com.tianji.r.core.util;

import org.springframework.stereotype.Service;

@Service
public class HiveSource {

    private String host;
    private int port = 22;

    private SSHConnection rSSHConnection;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public SSHConnection getrSSHConnection() {
        return rSSHConnection;
    }

    public void setrSSHConnection(SSHConnection rSSHConnection) {
        this.rSSHConnection = rSSHConnection;
    }

}
