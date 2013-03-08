//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.source.model.SshSourceDTO;

/**
 * This is SshSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface SshSourceService extends SpringService {

    int insertSshSource(SshSourceDTO dto);
    int updateSshSource(SshSourceDTO dto);
    int saveSshSource(SshSourceDTO dto);
    int saveSshSource(SshSourceDTO dto, Map<String,Object> paramMap);
    int deleteSshSource(int id);
    int deleteSshSource(SshSourceDTO dto);
    

    SshSourceDTO getSshSourceById(int id);
    SshSourceDTO getSshSourceOne(Map<String,Object> paramMap);
    List<SshSourceDTO> getSshSources(Map<String,Object> paramMap);
    PageOutObject<SshSourceDTO> getSshSourcesPaging(Map<String,Object> paramMap, PageInObject page);
    int getSshSourcesCount(Map<String,Object> paramMap);
}

