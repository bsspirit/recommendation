//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.source.dao.HiveSourceDAO;
import com.tianji.r.biz.source.service.HiveSourceService;
import com.tianji.r.biz.source.model.HiveSourceDTO;

/**
 * This is HiveSource Service implemention
 * @author Conan Zhang
 * @date 2013-03-08
 */
@Service(value="hiveSourceService")
public class HiveSourceServiceImpl extends SpringServiceImpl implements HiveSourceService {

    @Autowired
    HiveSourceDAO hiveSourceDAO;

    public int insertHiveSource(HiveSourceDTO dto) {
        return hiveSourceDAO.insertHiveSource(dto);
    }
    
    public int updateHiveSource(HiveSourceDTO dto) {
        return hiveSourceDAO.updateHiveSource(dto);
    }
    
    public int saveHiveSource(HiveSourceDTO dto) {
        if (dto.getId() > 0) {
            return updateHiveSource(dto);
        }
        return insertHiveSource(dto);
    }

    public int saveHiveSource(HiveSourceDTO dto, Map<String, Object> paramMap) {
        HiveSourceDTO obj = getHiveSourceOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateHiveSource(dto);
        }
         return insertHiveSource(dto);
    }

    public int deleteHiveSource(int id) {
        return hiveSourceDAO.deleteHiveSource(id);
    }

	public int deleteHiveSource(HiveSourceDTO dto) {
        return hiveSourceDAO.deleteHiveSources(dto);
    }

    public HiveSourceDTO getHiveSourceById(int id) {
        return hiveSourceDAO.getHiveSourceById(id);
    }
    
    public HiveSourceDTO getHiveSourceOne(Map<String, Object> paramMap) {
        return hiveSourceDAO.getHiveSourceOne(paramMap);
    }

    public List<HiveSourceDTO> getHiveSources(Map<String, Object> paramMap) {
        return hiveSourceDAO.getHiveSources(paramMap);
    }

    public PageOutObject<HiveSourceDTO> getHiveSourcesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<HiveSourceDTO> list = hiveSourceDAO.getHiveSources(paramMap);
        int count = hiveSourceDAO.getHiveSourcesCount(paramMap);
        return new PageOutObject<HiveSourceDTO>(count, list, page);
    }
    
    public int getHiveSourcesCount(Map<String, Object> paramMap) {
        return hiveSourceDAO.getHiveSourcesCount(paramMap);
    }

}
