package com.tianji.r.core.util;

import java.io.IOException;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ch.ethz.ssh2.Connection;

@Service
@Scope(value = "prototype")
public class SCPConnection {

    private String host;
    private int port = 22;
    private String username;
    private String password;

    public Connection init() throws IOException {
        return new Connection(host, port);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
