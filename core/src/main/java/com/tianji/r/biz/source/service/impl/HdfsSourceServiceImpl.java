//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.source.dao.HdfsSourceDAO;
import com.tianji.r.biz.source.service.HdfsSourceService;
import com.tianji.r.biz.source.model.HdfsSourceDTO;

/**
 * This is HdfsSource Service implemention
 * @author Conan Zhang
 * @date 2013-03-08
 */
@Service(value="hdfsSourceService")
public class HdfsSourceServiceImpl extends SpringServiceImpl implements HdfsSourceService {

    @Autowired
    HdfsSourceDAO hdfsSourceDAO;

    public int insertHdfsSource(HdfsSourceDTO dto) {
        return hdfsSourceDAO.insertHdfsSource(dto);
    }
    
    public int updateHdfsSource(HdfsSourceDTO dto) {
        return hdfsSourceDAO.updateHdfsSource(dto);
    }
    
    public int saveHdfsSource(HdfsSourceDTO dto) {
        if (dto.getId() > 0) {
            return updateHdfsSource(dto);
        }
        return insertHdfsSource(dto);
    }

    public int saveHdfsSource(HdfsSourceDTO dto, Map<String, Object> paramMap) {
        HdfsSourceDTO obj = getHdfsSourceOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateHdfsSource(dto);
        }
         return insertHdfsSource(dto);
    }

    public int deleteHdfsSource(int id) {
        return hdfsSourceDAO.deleteHdfsSource(id);
    }

	public int deleteHdfsSource(HdfsSourceDTO dto) {
        return hdfsSourceDAO.deleteHdfsSources(dto);
    }

    public HdfsSourceDTO getHdfsSourceById(int id) {
        return hdfsSourceDAO.getHdfsSourceById(id);
    }
    
    public HdfsSourceDTO getHdfsSourceOne(Map<String, Object> paramMap) {
        return hdfsSourceDAO.getHdfsSourceOne(paramMap);
    }

    public List<HdfsSourceDTO> getHdfsSources(Map<String, Object> paramMap) {
        return hdfsSourceDAO.getHdfsSources(paramMap);
    }

    public PageOutObject<HdfsSourceDTO> getHdfsSourcesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<HdfsSourceDTO> list = hdfsSourceDAO.getHdfsSources(paramMap);
        int count = hdfsSourceDAO.getHdfsSourcesCount(paramMap);
        return new PageOutObject<HdfsSourceDTO>(count, list, page);
    }
    
    public int getHdfsSourcesCount(Map<String, Object> paramMap) {
        return hdfsSourceDAO.getHdfsSourcesCount(paramMap);
    }

}
