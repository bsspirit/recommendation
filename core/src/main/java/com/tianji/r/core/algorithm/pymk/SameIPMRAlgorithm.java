package com.tianji.r.core.algorithm.pymk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class SameIPMRAlgorithm {

    public static class SameIPMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
        @Override
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException {
            String line = value.toString();
            String[] tokens = line.split(",");
            output.collect(new Text(tokens[1]), new IntWritable(Integer.parseInt(tokens[0])));
        }
    }

    public static class SameIPReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, Text> {
        @Override
        public void reduce(Text key, Iterator<IntWritable> values, OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
            
            Set<Integer> set = new HashSet<Integer>();
            List<Integer> list = new ArrayList<Integer>();

            while (values.hasNext()) {
                int userid = values.next().get();
                if (set.add(userid)) {
                    // users.append(",").append(userid);
                    list.add(userid);
                }

            }
            if (set.size() > 1) {
                // output.collect(key, new Text(users.toString().substring(1)));
                for (int i = 0; i < list.size() - 1; i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        StringBuilder users = new StringBuilder();
                        users.append(list.get(i)).append(",").append(list.get(j));
                        output.collect(null, new Text(users.toString()));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String input = "hdfs://192.168.1.243:9000/user/hdfs/o_same_ip";
        String output = "hdfs://192.168.1.243:9000/user/hdfs/o_same_ip/result";

        // JobConf conf = MyConf.getConf(DemoTT.class, MyConf.ENV.TIANJI);
        JobConf conf = new JobConf(SameIPMRAlgorithm.class);
        conf.addResource("classpath:/r/qa/hadoop-core-site.xml");
        conf.addResource("classpath:/r/qa/hadoop-hdfs-site.xml");
        conf.addResource("classpath:/r/qa/hadoop-mapred-site.xml");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(SameIPMapper.class);
        conf.setReducerClass(SameIPReducer.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(input));
        FileOutputFormat.setOutputPath(conf, new Path(output));

        JobClient.runJob(conf);
    }

}
