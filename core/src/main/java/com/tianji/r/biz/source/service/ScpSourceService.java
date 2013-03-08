//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.source.model.ScpSourceDTO;

/**
 * This is ScpSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface ScpSourceService extends SpringService {

    int insertScpSource(ScpSourceDTO dto);
    int updateScpSource(ScpSourceDTO dto);
    int saveScpSource(ScpSourceDTO dto);
    int saveScpSource(ScpSourceDTO dto, Map<String,Object> paramMap);
    int deleteScpSource(int id);
    int deleteScpSource(ScpSourceDTO dto);
    

    ScpSourceDTO getScpSourceById(int id);
    ScpSourceDTO getScpSourceOne(Map<String,Object> paramMap);
    List<ScpSourceDTO> getScpSources(Map<String,Object> paramMap);
    PageOutObject<ScpSourceDTO> getScpSourcesPaging(Map<String,Object> paramMap, PageInObject page);
    int getScpSourcesCount(Map<String,Object> paramMap);
}

