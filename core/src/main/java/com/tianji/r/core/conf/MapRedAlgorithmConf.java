package com.tianji.r.core.conf;

import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reducer;

import com.tianji.r.core.conf.model.HdfsPathNew;

public class MapRedAlgorithmConf extends JobConf {

    private HdfsPathNew hdfsPath;
    private String mapReduceClass;
    private String outputKeyClass;
    private String outputValueClass;
    private String mapperClass;
    private String reducerClass;
    
    public String getResultPath() {
        return getHdfsPath().getStorePath() + "/result";
    }

    public HdfsPathNew getHdfsPath() {
        return hdfsPath;
    }

    public void setHdfsPath(HdfsPathNew hdfsPath) {
        this.hdfsPath = hdfsPath;
    }

    public Class<?> getMapReduceClazz() throws ClassNotFoundException {
        return Class.forName(mapReduceClass);
    }

    public String getMapReduceClass() {
        return mapReduceClass;
    }

    public void setMapReduceClass(String mapReduceClass) {
        this.mapReduceClass = mapReduceClass;
    }
    
    public Class<?> getOutputKeyClazz() throws ClassNotFoundException {
        return Class.forName(outputKeyClass);
    }

    public String getOutputKeyClass() {
        return outputKeyClass;
    }

    public void setOutputKeyClass(String outputKeyClass) {
        this.outputKeyClass = outputKeyClass;
    }

    public Class<?> getOutputValueClazz() throws ClassNotFoundException {
        return Class.forName(outputValueClass);
    }

    public String getOutputValueClass() {
        return outputValueClass;
    }

    public void setOutputValueClass(String outputValueClass) {
        this.outputValueClass = outputValueClass;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Class<? extends Mapper> getMapperClazz() throws ClassNotFoundException {
        return (Class<? extends Mapper>) Class.forName(mapperClass);
    }

    public String getMapperClass() {
        return mapperClass;
    }

    public void setMapperClass(String mapperClass) {
        this.mapperClass = mapperClass;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Class<? extends Reducer> getReducerClazz() throws ClassNotFoundException {
        return (Class<? extends Reducer>) Class.forName(reducerClass);
    }

    public String getReducerClass() {
        return reducerClass;
    }

    public void setReducerClass(String reducerClass) {
        this.reducerClass = reducerClass;
    }

}
