//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.source.model.SshSourceDTO;

/**
 * This is SshSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface SshSourceDAO extends MybatisDAO {

    int insertSshSource(SshSourceDTO dto);
    int updateSshSource(SshSourceDTO dto);
    int deleteSshSource(int id);
    int deleteSshSources (SshSourceDTO dto);

    SshSourceDTO getSshSourceById(int id);
    SshSourceDTO getSshSourceOne(Map<String,Object> paramMap);
    List<SshSourceDTO> getSshSources(Map<String,Object> paramMap);
    int getSshSourcesCount(Map<String,Object> paramMap);
}

