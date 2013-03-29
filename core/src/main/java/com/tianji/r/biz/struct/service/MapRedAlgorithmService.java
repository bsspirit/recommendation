//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.MapRedAlgorithmDTO;

/**
 * This is MapRedAlgorithm DAO interface
 * @author Conan Zhang
 * @date 2013-03-27
 */
public interface MapRedAlgorithmService extends SpringService {

    int insertMapRedAlgorithm(MapRedAlgorithmDTO dto);
    int updateMapRedAlgorithm(MapRedAlgorithmDTO dto);
    int saveMapRedAlgorithm(MapRedAlgorithmDTO dto);
    int saveMapRedAlgorithm(MapRedAlgorithmDTO dto, Map<String,Object> paramMap);
    int deleteMapRedAlgorithm(int id);
    int deleteMapRedAlgorithm(MapRedAlgorithmDTO dto);
    

    MapRedAlgorithmDTO getMapRedAlgorithmById(int id);
    MapRedAlgorithmDTO getMapRedAlgorithmOne(Map<String,Object> paramMap);
    List<MapRedAlgorithmDTO> getMapRedAlgorithms(Map<String,Object> paramMap);
    PageOutObject<MapRedAlgorithmDTO> getMapRedAlgorithmsPaging(Map<String,Object> paramMap, PageInObject page);
    int getMapRedAlgorithmsCount(Map<String,Object> paramMap);
}

