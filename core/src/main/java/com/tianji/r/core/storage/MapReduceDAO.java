package com.tianji.r.core.storage;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tianji.r.core.util.HdfsSource;

@Service
@Scope(value = "prototype")
public class MapReduceDAO {

    private static final Logger log = Logger.getLogger(MapReduceDAO.class);

    @Autowired
    private HdfsDAO hdfsDAO;

    private HdfsSource hdfsSource;
    private JobConf conf;

    public void setHdfsSource(HdfsSource hdfsSource) {
        this.hdfsSource = hdfsSource;
    }

    public JobConf createJobConf(Class<?> clazz) {
        conf = new JobConf(clazz);
        for (String resource : hdfsSource.getResourceFiles()) {
            conf.addResource(resource);
        }
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        return conf;
    }

    public String getHdfsPath() {
        // return conf.get("fs.default.name");
        return "hdfs://192.168.1.243:9000";
    }

    public void exec() throws IOException {
        JobClient.runJob(conf);
    }

    public void setInputPath(String input) {
        FileInputFormat.setInputPaths(conf, new Path(getHdfsPath() + input));
        log.info("input==>" + input);
    }

    public void setOutputPath(String output) throws IOException {
        FileOutputFormat.setOutputPath(conf, new Path(getHdfsPath() + output));
        hdfsDAO.setHdfsPath(getHdfsPath());
        hdfsDAO.rmr(output);
        log.info("output==>" + output);
    }

}
