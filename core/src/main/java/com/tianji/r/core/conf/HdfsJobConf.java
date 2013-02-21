package com.tianji.r.core.conf;

import java.util.List;

import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.Reducer;

public class HdfsJobConf extends JobConf {

    private String inputPath;
    private String outputPath;
    private String mapReduceClass;
    private String outputKeyClass;
    private String outputValueClass;
    private String mapperClass;
    private String reducerClass;

    public Class<?> getOutputKeyClazz() throws ClassNotFoundException {
        return Class.forName(outputKeyClass);
    }

    public void setOutputKeyClass(String outputKeyClass) {
        this.outputKeyClass = outputKeyClass;
    }

    public Class<?> getOutputValueClazz() throws ClassNotFoundException {
        return Class.forName(outputValueClass);
    }

    public void setOutputValueClass(String outputValueClass) {
        this.outputValueClass = outputValueClass;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Class<? extends Mapper> getMapperClazz() throws ClassNotFoundException {
        return (Class<? extends Mapper>) Class.forName(mapperClass);
    }

    public void setMapperClass(String mapperClass) {
        this.mapperClass = mapperClass;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Class<? extends Reducer> getReducerClazz() throws ClassNotFoundException {
        return (Class<? extends Reducer>) Class.forName(reducerClass);
    }

    public String getOutputKeyClass() {
        return outputKeyClass;
    }

    public String getOutputValueClass() {
        return outputValueClass;
    }

    public String getMapperClass() {
        return mapperClass;
    }

    public String getReducerClass() {
        return reducerClass;
    }

    public void setReducerClass(String reducerClass) {
        this.reducerClass = reducerClass;
    }

    public String getMapReduceClass() {
        return mapReduceClass;
    }

    public Class<?> getMapReduceClazz() throws ClassNotFoundException {
        return Class.forName(mapReduceClass);
    }

    public void setMapReduceClass(String mapReduceClass) {
        this.mapReduceClass = mapReduceClass;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    private List<String> importIntoHdfsTables;

    public List<String> getImportIntoHdfsTables() {
        return importIntoHdfsTables;
    }

    public void setImportIntoHdfsTables(List<String> importIntoHdfsTables) {
        this.importIntoHdfsTables = importIntoHdfsTables;
    }

}
