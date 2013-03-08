//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.source.model.DatabaseSourceDTO;

/**
 * This is DatabaseSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface DatabaseSourceDAO extends MybatisDAO {

    int insertDatabaseSource(DatabaseSourceDTO dto);
    int updateDatabaseSource(DatabaseSourceDTO dto);
    int deleteDatabaseSource(int id);
    int deleteDatabaseSources (DatabaseSourceDTO dto);

    DatabaseSourceDTO getDatabaseSourceById(int id);
    DatabaseSourceDTO getDatabaseSourceOne(Map<String,Object> paramMap);
    List<DatabaseSourceDTO> getDatabaseSources(Map<String,Object> paramMap);
    int getDatabaseSourcesCount(Map<String,Object> paramMap);
}

