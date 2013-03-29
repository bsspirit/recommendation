//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.HiveTableDTO;

/**
 * This is HiveTable DAO interface
 * @author Conan Zhang
 * @date 2013-03-27
 */
public interface HiveTableService extends SpringService {

    int insertHiveTable(HiveTableDTO dto);
    int updateHiveTable(HiveTableDTO dto);
    int saveHiveTable(HiveTableDTO dto);
    int saveHiveTable(HiveTableDTO dto, Map<String,Object> paramMap);
    int deleteHiveTable(int id);
    int deleteHiveTable(HiveTableDTO dto);
    

    HiveTableDTO getHiveTableById(int id);
    HiveTableDTO getHiveTableOne(Map<String,Object> paramMap);
    List<HiveTableDTO> getHiveTables(Map<String,Object> paramMap);
    PageOutObject<HiveTableDTO> getHiveTablesPaging(Map<String,Object> paramMap, PageInObject page);
    int getHiveTablesCount(Map<String,Object> paramMap);
}

