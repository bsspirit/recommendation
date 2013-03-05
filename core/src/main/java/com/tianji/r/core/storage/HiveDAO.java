package com.tianji.r.core.storage;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class HiveDAO {

    private static final Logger log = Logger.getLogger(HiveDAO.class);

    private HiveTemplate hiveTemplate;

    public void setHiveTemplate(HiveTemplate hiveTemplate) {
        this.hiveTemplate = hiveTemplate;
    }

    public List<String> query(String hql) {
        log.info(hql);
        return hiveTemplate.query(hql);
    }

    public List<String> query(String hql, Map<String, Object> map) {
        log.info(hql);
        return hiveTemplate.query(hql, map);
    }

    public String queryForString(String hql) {
        log.info(hql);
        return hiveTemplate.queryForString(hql);
    }

}
