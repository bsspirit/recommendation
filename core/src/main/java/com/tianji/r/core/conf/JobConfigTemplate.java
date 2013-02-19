package com.tianji.r.core.conf;

public interface JobConfigTemplate {
    
    public void setJobConf(JobConf jobConf);
    public void exportCSVFromProduction();
    public void downloadCSVFromProduction();
    public void importCSVIntoPlatform();
    public void transformData();
    public void importDataIntoHive();
    public void importDataIntoHDFS();
    public void mahoutAlgorithm();
    public void mapReduceAlgorithm();
    public void hiveAlgorithm();
    public void basicAlgorithm();
    public void exportResult();
    
}
