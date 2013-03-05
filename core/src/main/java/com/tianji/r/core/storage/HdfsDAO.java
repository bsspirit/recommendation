package com.tianji.r.core.storage;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class HdfsDAO {

    // private String HDFS = "hdfs://42.121.108.236:9000/";

    private String hdfsPath;

    private static final Logger log = Logger.getLogger(HdfsDAO.class);

    public void mkdirs(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        if (!fs.exists(path)) {
            fs.mkdirs(path);
            log.info("Create: " + folder);
        }
        fs.close();
    }

    public void rmr(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        fs.deleteOnExit(path);
        log.info("Delete: " + folder);
        fs.close();
    }

    public void ls(String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        FileStatus[] list = fs.listStatus(path);
        log.info("ls: " + folder);
        log.info("==========================================================");
        for (FileStatus f : list) {
            System.out.printf("name: %s, folder: %s, size: %d\n", f.getPath(), f.isDir(), f.getLen());
        }
        log.info("==========================================================");
        fs.close();
    }

    public void createFile(String file, String content) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        byte[] buff = content.getBytes();
        FSDataOutputStream os = null;
        try {
            os = fs.create(new Path(file));
            os.write(buff, 0, buff.length);
            log.info("Create: " + file);
        } finally {
            if (os != null)
                os.close();
        }
        fs.close();
    }

    public void copyFile(String local, String remote) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        log.info("copy from: " + local + " to " + remote);
        fs.close();
    }

    public void upload(String local, String remote) throws IOException {
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        fs.copyFromLocalFile(new Path(local), new Path(remote));
        log.info("upload: from " + local + " to " + remote);
        fs.close();
    }

    public void download(String remote, String local) throws IOException {
        Path path = new Path(remote);
        FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        fs.copyToLocalFile(path, new Path(local));
        log.info("download: from" + remote + " to " + local);
        fs.close();
    }

    public void location() throws IOException {
        // String folder = hdfsPath + "create/";
        // String file = "t2.txt";
        // FileSystem fs = FileSystem.get(URI.create(hdfsPath), new Configuration());
        // FileStatus f = fs.getFileStatus(new Path(folder + file));
        // BlockLocation[] list = fs.getFileBlockLocations(f, 0, f.getLen());
        //
        // System.out.println("File Location: " + folder + file);
        // for (BlockLocation bl : list) {
        // String[] hosts = bl.getHosts();
        // for (String host : hosts) {
        // System.out.println("host:" + host);
        // }
        // }
        // fs.close();
    }

    public String getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(String hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

}
