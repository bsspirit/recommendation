package com.tianji.r.core.etl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.SshDAO;
import com.tianji.r.core.util.HdfsSource;

@Service
public class HdfsImportCommand {

    // private static final Logger log = Logger.getLogger(HdfsImportService.class);

    @Autowired
    SshDAO sshDAO;

    HdfsSource hdfsSource;

    public void setHdfsSource(HdfsSource hdfsSource) {
        this.hdfsSource = hdfsSource;
    }

    public void exec(String command) throws IOException {
        sshDAO.init(hdfsSource.getSshSource());
        List<String> lines = new ArrayList<String>();
        lines.add(command);
        exec(lines);
    }

    public void exec(List<String> commands) throws IOException {
        sshDAO.init(hdfsSource.getSshSource());
        for (String command : commands) {
            sshDAO.exec(command);
        }
        sshDAO.stop();
    }
}
