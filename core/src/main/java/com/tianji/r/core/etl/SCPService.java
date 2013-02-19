package com.tianji.r.core.etl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.SCPClient;

import com.tianji.r.core.util.SCPConnection;

@Service
public class SCPService {

    private Connection conn;

    public void setSCPConnection(SCPConnection scpConnection) throws IOException {
        conn = scpConnection.init();
        conn.connect();
        boolean isAuthenticated = conn.authenticateWithPassword(scpConnection.getUsername(), scpConnection.getPassword());
        if (isAuthenticated == false)
            throw new IOException("Authentication failed.");
    }

    public void get(String remoteFile, String localFolder) throws IOException {
        SCPClient client = new SCPClient(conn);
        client.get(remoteFile, localFolder);
        conn.close();
    }

    public void put(String localFile, String remoteFolder) throws IOException {
        SCPClient client = new SCPClient(conn);
        client.put(localFile, remoteFolder);
        conn.close();
    }

}
