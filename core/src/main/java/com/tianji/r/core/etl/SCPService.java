package com.tianji.r.core.etl;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

import com.tianji.r.core.util.SCPConnection;

@Service
@Scope(value = "prototype")
public class SCPService {

    private static final Logger log = Logger.getLogger(SCPService.class);

    private Connection conn;

    public void setSCPConnection(SCPConnection scpConnection) throws IOException {
        conn = scpConnection.init();
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(scpConnection.getUsername(), scpConnection.getPassword());
        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");
    }

    public void get(String remoteFile, String localFolder) throws IOException {
        log.info("SCP Get FILE:" + remoteFile + " TO " + localFolder);

        SCPClient client = new SCPClient(conn);
        client.get(remoteFile, localFolder);
        conn.close();
    }

    public void put(String localFile, String remoteFolder) throws IOException {
        log.info("SCP Upload File:" + localFile + " TO " + remoteFolder);
        SCPClient client = new SCPClient(conn);
        client.put(localFile, remoteFolder);
        conn.close();
    }

}
