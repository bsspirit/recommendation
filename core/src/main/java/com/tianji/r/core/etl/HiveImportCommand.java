package com.tianji.r.core.etl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.SshDAO;
import com.tianji.r.core.util.HiveSource;

@Service
public class HiveImportCommand {

    // private static final Logger log = Logger.getLogger(HiveImportCommand.class);

    @Autowired
    SshDAO sshDAO;

    HiveSource hiveSource;

    public void setHiveSource(HiveSource hiveSource) {
        this.hiveSource = hiveSource;
    }

    public void exec(String command) throws IOException {
        sshDAO.init(hiveSource.getSshSource());
        List<String> lines = new ArrayList<String>();
        lines.add(command);
        exec(lines);
    }

    public void exec(List<String> commands) throws IOException {
        sshDAO.init(hiveSource.getSshSource());
        for (String command : commands) {
            sshDAO.exec(command);
        }
        sshDAO.stop();
    }
}
