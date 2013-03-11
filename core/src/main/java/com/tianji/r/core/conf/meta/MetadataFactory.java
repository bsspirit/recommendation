package com.tianji.r.core.conf.meta;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.biz.source.model.DatabaseSourceDTO;
import com.tianji.r.core.conf.Global;

@Service
public class MetadataFactory {

    @Autowired
    Global global;

    /**
     * Create BasicDataSource
     */
    public void createDataSource(DatabaseSourceDTO dataSourceDTO) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(dataSourceDTO.getDriver());
        ds.setUrl(dataSourceDTO.getUrl());
        ds.setUsername(dataSourceDTO.getUsername());
        ds.setPassword(dataSourceDTO.getPassword());
        ds.setMaxActive(dataSourceDTO.getMaxActive());
        ds.setMaxIdle(dataSourceDTO.getMaxIdle());
        ds.setMaxWait(dataSourceDTO.getMaxWait());

        global.setDto(dataSourceDTO.getBeanName(), dataSourceDTO);
        global.setMeta(dataSourceDTO.getBeanName(), ds);
    }
    
    
    
    

}
