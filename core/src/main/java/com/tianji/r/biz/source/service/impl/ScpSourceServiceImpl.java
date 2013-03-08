//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.source.dao.ScpSourceDAO;
import com.tianji.r.biz.source.service.ScpSourceService;
import com.tianji.r.biz.source.model.ScpSourceDTO;

/**
 * This is ScpSource Service implemention
 * @author Conan Zhang
 * @date 2013-03-08
 */
@Service(value="scpSourceService")
public class ScpSourceServiceImpl extends SpringServiceImpl implements ScpSourceService {

    @Autowired
    ScpSourceDAO scpSourceDAO;

    public int insertScpSource(ScpSourceDTO dto) {
        return scpSourceDAO.insertScpSource(dto);
    }
    
    public int updateScpSource(ScpSourceDTO dto) {
        return scpSourceDAO.updateScpSource(dto);
    }
    
    public int saveScpSource(ScpSourceDTO dto) {
        if (dto.getId() > 0) {
            return updateScpSource(dto);
        }
        return insertScpSource(dto);
    }

    public int saveScpSource(ScpSourceDTO dto, Map<String, Object> paramMap) {
        ScpSourceDTO obj = getScpSourceOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateScpSource(dto);
        }
         return insertScpSource(dto);
    }

    public int deleteScpSource(int id) {
        return scpSourceDAO.deleteScpSource(id);
    }

	public int deleteScpSource(ScpSourceDTO dto) {
        return scpSourceDAO.deleteScpSources(dto);
    }

    public ScpSourceDTO getScpSourceById(int id) {
        return scpSourceDAO.getScpSourceById(id);
    }
    
    public ScpSourceDTO getScpSourceOne(Map<String, Object> paramMap) {
        return scpSourceDAO.getScpSourceOne(paramMap);
    }

    public List<ScpSourceDTO> getScpSources(Map<String, Object> paramMap) {
        return scpSourceDAO.getScpSources(paramMap);
    }

    public PageOutObject<ScpSourceDTO> getScpSourcesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<ScpSourceDTO> list = scpSourceDAO.getScpSources(paramMap);
        int count = scpSourceDAO.getScpSourcesCount(paramMap);
        return new PageOutObject<ScpSourceDTO>(count, list, page);
    }
    
    public int getScpSourcesCount(Map<String, Object> paramMap) {
        return scpSourceDAO.getScpSourcesCount(paramMap);
    }

}
