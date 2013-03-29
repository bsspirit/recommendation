//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.MapRedAlgorithmDAO;
import com.tianji.r.biz.struct.service.MapRedAlgorithmService;
import com.tianji.r.biz.struct.model.MapRedAlgorithmDTO;

/**
 * This is MapRedAlgorithm Service implemention
 * @author Conan Zhang
 * @date 2013-03-27
 */
@Service(value="mapRedAlgorithmService")
public class MapRedAlgorithmServiceImpl extends SpringServiceImpl implements MapRedAlgorithmService {

    @Autowired
    MapRedAlgorithmDAO mapRedAlgorithmDAO;

    public int insertMapRedAlgorithm(MapRedAlgorithmDTO dto) {
        return mapRedAlgorithmDAO.insertMapRedAlgorithm(dto);
    }
    
    public int updateMapRedAlgorithm(MapRedAlgorithmDTO dto) {
        return mapRedAlgorithmDAO.updateMapRedAlgorithm(dto);
    }
    
    public int saveMapRedAlgorithm(MapRedAlgorithmDTO dto) {
        if (dto.getId() > 0) {
            return updateMapRedAlgorithm(dto);
        }
        return insertMapRedAlgorithm(dto);
    }

    public int saveMapRedAlgorithm(MapRedAlgorithmDTO dto, Map<String, Object> paramMap) {
        MapRedAlgorithmDTO obj = getMapRedAlgorithmOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateMapRedAlgorithm(dto);
        }
         return insertMapRedAlgorithm(dto);
    }

    public int deleteMapRedAlgorithm(int id) {
        return mapRedAlgorithmDAO.deleteMapRedAlgorithm(id);
    }

	public int deleteMapRedAlgorithm(MapRedAlgorithmDTO dto) {
        return mapRedAlgorithmDAO.deleteMapRedAlgorithms(dto);
    }

    public MapRedAlgorithmDTO getMapRedAlgorithmById(int id) {
        return mapRedAlgorithmDAO.getMapRedAlgorithmById(id);
    }
    
    public MapRedAlgorithmDTO getMapRedAlgorithmOne(Map<String, Object> paramMap) {
        return mapRedAlgorithmDAO.getMapRedAlgorithmOne(paramMap);
    }

    public List<MapRedAlgorithmDTO> getMapRedAlgorithms(Map<String, Object> paramMap) {
        return mapRedAlgorithmDAO.getMapRedAlgorithms(paramMap);
    }

    public PageOutObject<MapRedAlgorithmDTO> getMapRedAlgorithmsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<MapRedAlgorithmDTO> list = mapRedAlgorithmDAO.getMapRedAlgorithms(paramMap);
        int count = mapRedAlgorithmDAO.getMapRedAlgorithmsCount(paramMap);
        return new PageOutObject<MapRedAlgorithmDTO>(count, list, page);
    }
    
    public int getMapRedAlgorithmsCount(Map<String, Object> paramMap) {
        return mapRedAlgorithmDAO.getMapRedAlgorithmsCount(paramMap);
    }

}
