//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.source.model.DatabaseSourceDTO;

/**
 * This is DatabaseSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface DatabaseSourceService extends SpringService {

    int insertDatabaseSource(DatabaseSourceDTO dto);
    int updateDatabaseSource(DatabaseSourceDTO dto);
    int saveDatabaseSource(DatabaseSourceDTO dto);
    int saveDatabaseSource(DatabaseSourceDTO dto, Map<String,Object> paramMap);
    int deleteDatabaseSource(int id);
    int deleteDatabaseSource(DatabaseSourceDTO dto);
    

    DatabaseSourceDTO getDatabaseSourceById(int id);
    DatabaseSourceDTO getDatabaseSourceOne(Map<String,Object> paramMap);
    List<DatabaseSourceDTO> getDatabaseSources(Map<String,Object> paramMap);
    PageOutObject<DatabaseSourceDTO> getDatabaseSourcesPaging(Map<String,Object> paramMap, PageInObject page);
    int getDatabaseSourcesCount(Map<String,Object> paramMap);
}

