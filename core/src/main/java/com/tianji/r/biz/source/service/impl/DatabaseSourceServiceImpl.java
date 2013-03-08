//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.source.dao.DatabaseSourceDAO;
import com.tianji.r.biz.source.service.DatabaseSourceService;
import com.tianji.r.biz.source.model.DatabaseSourceDTO;

/**
 * This is DatabaseSource Service implemention
 * @author Conan Zhang
 * @date 2013-03-08
 */
@Service(value="databaseSourceService")
public class DatabaseSourceServiceImpl extends SpringServiceImpl implements DatabaseSourceService {

    @Autowired
    DatabaseSourceDAO databaseSourceDAO;

    public int insertDatabaseSource(DatabaseSourceDTO dto) {
        return databaseSourceDAO.insertDatabaseSource(dto);
    }
    
    public int updateDatabaseSource(DatabaseSourceDTO dto) {
        return databaseSourceDAO.updateDatabaseSource(dto);
    }
    
    public int saveDatabaseSource(DatabaseSourceDTO dto) {
        if (dto.getId() > 0) {
            return updateDatabaseSource(dto);
        }
        return insertDatabaseSource(dto);
    }

    public int saveDatabaseSource(DatabaseSourceDTO dto, Map<String, Object> paramMap) {
        DatabaseSourceDTO obj = getDatabaseSourceOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateDatabaseSource(dto);
        }
         return insertDatabaseSource(dto);
    }

    public int deleteDatabaseSource(int id) {
        return databaseSourceDAO.deleteDatabaseSource(id);
    }

	public int deleteDatabaseSource(DatabaseSourceDTO dto) {
        return databaseSourceDAO.deleteDatabaseSources(dto);
    }

    public DatabaseSourceDTO getDatabaseSourceById(int id) {
        return databaseSourceDAO.getDatabaseSourceById(id);
    }
    
    public DatabaseSourceDTO getDatabaseSourceOne(Map<String, Object> paramMap) {
        return databaseSourceDAO.getDatabaseSourceOne(paramMap);
    }

    public List<DatabaseSourceDTO> getDatabaseSources(Map<String, Object> paramMap) {
        return databaseSourceDAO.getDatabaseSources(paramMap);
    }

    public PageOutObject<DatabaseSourceDTO> getDatabaseSourcesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<DatabaseSourceDTO> list = databaseSourceDAO.getDatabaseSources(paramMap);
        int count = databaseSourceDAO.getDatabaseSourcesCount(paramMap);
        return new PageOutObject<DatabaseSourceDTO>(count, list, page);
    }
    
    public int getDatabaseSourcesCount(Map<String, Object> paramMap) {
        return databaseSourceDAO.getDatabaseSourcesCount(paramMap);
    }

}
