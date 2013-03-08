//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.source.model.HiveSourceDTO;

/**
 * This is HiveSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface HiveSourceService extends SpringService {

    int insertHiveSource(HiveSourceDTO dto);
    int updateHiveSource(HiveSourceDTO dto);
    int saveHiveSource(HiveSourceDTO dto);
    int saveHiveSource(HiveSourceDTO dto, Map<String,Object> paramMap);
    int deleteHiveSource(int id);
    int deleteHiveSource(HiveSourceDTO dto);
    

    HiveSourceDTO getHiveSourceById(int id);
    HiveSourceDTO getHiveSourceOne(Map<String,Object> paramMap);
    List<HiveSourceDTO> getHiveSources(Map<String,Object> paramMap);
    PageOutObject<HiveSourceDTO> getHiveSourcesPaging(Map<String,Object> paramMap, PageInObject page);
    int getHiveSourcesCount(Map<String,Object> paramMap);
}

