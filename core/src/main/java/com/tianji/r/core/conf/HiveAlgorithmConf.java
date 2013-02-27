package com.tianji.r.core.conf;

import java.util.List;

import org.springframework.data.hadoop.hive.HiveTemplate;

import com.tianji.r.core.conf.model.HiveTableNew;

public class HiveAlgorithmConf extends JobConf {

    private HiveTemplate hiveTemplate;
    private HiveTableNew hiveTable;
    private List<String> hqls;

    public HiveTemplate getHiveTemplate() {
        return hiveTemplate;
    }

    public void setHiveTemplate(HiveTemplate hiveTemplate) {
        this.hiveTemplate = hiveTemplate;
    }

    public HiveTableNew getHiveTable() {
        return hiveTable;
    }

    public void setHiveTable(HiveTableNew hiveTable) {
        this.hiveTable = hiveTable;
    }

    public List<String> getHqls() {
        return hqls;
    }

    public void setHqls(List<String> hqls) {
        this.hqls = hqls;
    }

}
