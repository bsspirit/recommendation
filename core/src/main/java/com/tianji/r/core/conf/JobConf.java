package com.tianji.r.core.conf;

/**
 * Job Parameters
 * 
 * @author Conan_Z
 * 
 */
abstract public class JobConf {

    private String taskName;

    // private List<String> transformSQLList; //TODO not set

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

}
