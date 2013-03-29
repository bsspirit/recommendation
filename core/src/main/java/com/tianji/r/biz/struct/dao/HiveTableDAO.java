//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.HiveTableDTO;

/**
 * This is HiveTable DAO interface
 * @author Conan Zhang
 * @date 2013-03-27
 */
public interface HiveTableDAO extends MybatisDAO {

    int insertHiveTable(HiveTableDTO dto);
    int updateHiveTable(HiveTableDTO dto);
    int deleteHiveTable(int id);
    int deleteHiveTables (HiveTableDTO dto);

    HiveTableDTO getHiveTableById(int id);
    HiveTableDTO getHiveTableOne(Map<String,Object> paramMap);
    List<HiveTableDTO> getHiveTables(Map<String,Object> paramMap);
    int getHiveTablesCount(Map<String,Object> paramMap);
}

