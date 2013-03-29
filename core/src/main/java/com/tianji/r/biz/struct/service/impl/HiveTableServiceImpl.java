//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.HiveTableDAO;
import com.tianji.r.biz.struct.service.HiveTableService;
import com.tianji.r.biz.struct.model.HiveTableDTO;

/**
 * This is HiveTable Service implemention
 * @author Conan Zhang
 * @date 2013-03-27
 */
@Service(value="hiveTableService")
public class HiveTableServiceImpl extends SpringServiceImpl implements HiveTableService {

    @Autowired
    HiveTableDAO hiveTableDAO;

    public int insertHiveTable(HiveTableDTO dto) {
        return hiveTableDAO.insertHiveTable(dto);
    }
    
    public int updateHiveTable(HiveTableDTO dto) {
        return hiveTableDAO.updateHiveTable(dto);
    }
    
    public int saveHiveTable(HiveTableDTO dto) {
        if (dto.getId() > 0) {
            return updateHiveTable(dto);
        }
        return insertHiveTable(dto);
    }

    public int saveHiveTable(HiveTableDTO dto, Map<String, Object> paramMap) {
        HiveTableDTO obj = getHiveTableOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateHiveTable(dto);
        }
         return insertHiveTable(dto);
    }

    public int deleteHiveTable(int id) {
        return hiveTableDAO.deleteHiveTable(id);
    }

	public int deleteHiveTable(HiveTableDTO dto) {
        return hiveTableDAO.deleteHiveTables(dto);
    }

    public HiveTableDTO getHiveTableById(int id) {
        return hiveTableDAO.getHiveTableById(id);
    }
    
    public HiveTableDTO getHiveTableOne(Map<String, Object> paramMap) {
        return hiveTableDAO.getHiveTableOne(paramMap);
    }

    public List<HiveTableDTO> getHiveTables(Map<String, Object> paramMap) {
        return hiveTableDAO.getHiveTables(paramMap);
    }

    public PageOutObject<HiveTableDTO> getHiveTablesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<HiveTableDTO> list = hiveTableDAO.getHiveTables(paramMap);
        int count = hiveTableDAO.getHiveTablesCount(paramMap);
        return new PageOutObject<HiveTableDTO>(count, list, page);
    }
    
    public int getHiveTablesCount(Map<String, Object> paramMap) {
        return hiveTableDAO.getHiveTablesCount(paramMap);
    }

}
