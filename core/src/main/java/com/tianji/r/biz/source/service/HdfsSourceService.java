//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.source.model.HdfsSourceDTO;

/**
 * This is HdfsSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface HdfsSourceService extends SpringService {

    int insertHdfsSource(HdfsSourceDTO dto);
    int updateHdfsSource(HdfsSourceDTO dto);
    int saveHdfsSource(HdfsSourceDTO dto);
    int saveHdfsSource(HdfsSourceDTO dto, Map<String,Object> paramMap);
    int deleteHdfsSource(int id);
    int deleteHdfsSource(HdfsSourceDTO dto);
    

    HdfsSourceDTO getHdfsSourceById(int id);
    HdfsSourceDTO getHdfsSourceOne(Map<String,Object> paramMap);
    List<HdfsSourceDTO> getHdfsSources(Map<String,Object> paramMap);
    PageOutObject<HdfsSourceDTO> getHdfsSourcesPaging(Map<String,Object> paramMap, PageInObject page);
    int getHdfsSourcesCount(Map<String,Object> paramMap);
}

