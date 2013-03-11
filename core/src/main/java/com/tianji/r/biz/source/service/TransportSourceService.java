//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.source.model.TransportSourceDTO;

/**
 * This is TransportSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface TransportSourceService extends SpringService {

    int insertTransportSource(TransportSourceDTO dto);
    int updateTransportSource(TransportSourceDTO dto);
    int saveTransportSource(TransportSourceDTO dto);
    int saveTransportSource(TransportSourceDTO dto, Map<String,Object> paramMap);
    int deleteTransportSource(int id);
    int deleteTransportSource(TransportSourceDTO dto);
    

    TransportSourceDTO getTransportSourceById(int id);
    TransportSourceDTO getTransportSourceOne(Map<String,Object> paramMap);
    List<TransportSourceDTO> getTransportSources(Map<String,Object> paramMap);
    PageOutObject<TransportSourceDTO> getTransportSourcesPaging(Map<String,Object> paramMap, PageInObject page);
    int getTransportSourcesCount(Map<String,Object> paramMap);
}

