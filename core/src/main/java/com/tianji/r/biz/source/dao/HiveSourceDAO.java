//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.source.model.HiveSourceDTO;

/**
 * This is HiveSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface HiveSourceDAO extends MybatisDAO {

    int insertHiveSource(HiveSourceDTO dto);
    int updateHiveSource(HiveSourceDTO dto);
    int deleteHiveSource(int id);
    int deleteHiveSources (HiveSourceDTO dto);

    HiveSourceDTO getHiveSourceById(int id);
    HiveSourceDTO getHiveSourceOne(Map<String,Object> paramMap);
    List<HiveSourceDTO> getHiveSources(Map<String,Object> paramMap);
    int getHiveSourcesCount(Map<String,Object> paramMap);
}

