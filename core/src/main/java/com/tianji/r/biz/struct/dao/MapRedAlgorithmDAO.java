//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.MapRedAlgorithmDTO;

/**
 * This is MapRedAlgorithm DAO interface
 * @author Conan Zhang
 * @date 2013-03-27
 */
public interface MapRedAlgorithmDAO extends MybatisDAO {

    int insertMapRedAlgorithm(MapRedAlgorithmDTO dto);
    int updateMapRedAlgorithm(MapRedAlgorithmDTO dto);
    int deleteMapRedAlgorithm(int id);
    int deleteMapRedAlgorithms (MapRedAlgorithmDTO dto);

    MapRedAlgorithmDTO getMapRedAlgorithmById(int id);
    MapRedAlgorithmDTO getMapRedAlgorithmOne(Map<String,Object> paramMap);
    List<MapRedAlgorithmDTO> getMapRedAlgorithms(Map<String,Object> paramMap);
    int getMapRedAlgorithmsCount(Map<String,Object> paramMap);
}

