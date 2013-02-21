package com.tianji.r.core.etl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.util.HdfsSource;

@Service
public class ImportHdfsService {

    private static final Logger log = Logger.getLogger(ImportHdfsService.class);

    @Autowired
    SSHService sSHService;

    HdfsSource hdfsSource;

    public void setHdfsSource(HdfsSource hdfsSource) {
        this.hdfsSource = hdfsSource;
    }

    public void exec(String command) throws IOException {
        sSHService.init(hdfsSource.getrSSHConnection());
        List<String> lines = new ArrayList<String>();
        lines.add(command);
        exec(lines);
    }

    public void exec(List<String> commands) throws IOException {
        sSHService.init(hdfsSource.getrSSHConnection());
        for (String command : commands) {
            sSHService.exec(command);
        }
        sSHService.stop();
    }
}
