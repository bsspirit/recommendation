package com.tianji.r.core.util;

import org.springframework.context.annotation.Scope;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class HiveSource {

    private String host;
    private int port = 22;
    private HiveTemplate hiveTemplate;
    private SshSource sshSource;

    public HiveTemplate getHiveTemplate() {
        return hiveTemplate;
    }

    public void setHiveTemplate(HiveTemplate hiveTemplate) {
        this.hiveTemplate = hiveTemplate;
    }

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

    public SshSource getSshSource() {
        return sshSource;
    }

    public void setSshSource(SshSource sshSource) {
        this.sshSource = sshSource;
    }

}
