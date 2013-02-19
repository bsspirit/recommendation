package com.tianji.r.core.etl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.core.util.HiveSource;

@Service
public class ImportHiveService {

    private static final Logger log = Logger.getLogger(ImportHiveService.class);

    @Autowired
    SSHService sSHService;

    HiveSource hiveSource;

    public void setHiveSource(HiveSource hiveSource) {
        this.hiveSource = hiveSource;
    }

    public void exec(String command) throws IOException {
        sSHService.init(hiveSource.getrSSHConnection());
        List<String> lines = new ArrayList<String>();
        lines.add(command);
        exec(lines);
    }

    public void exec(List<String> commands) throws IOException {
        sSHService.init(hiveSource.getrSSHConnection());
        for (String command : commands) {
            sSHService.exec(command);
        }
        sSHService.stop();
    }
}
