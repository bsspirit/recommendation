//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.source.dao.SshSourceDAO;
import com.tianji.r.biz.source.service.SshSourceService;
import com.tianji.r.biz.source.model.SshSourceDTO;

/**
 * This is SshSource Service implemention
 * @author Conan Zhang
 * @date 2013-03-08
 */
@Service(value="sshSourceService")
public class SshSourceServiceImpl extends SpringServiceImpl implements SshSourceService {

    @Autowired
    SshSourceDAO sshSourceDAO;

    public int insertSshSource(SshSourceDTO dto) {
        return sshSourceDAO.insertSshSource(dto);
    }
    
    public int updateSshSource(SshSourceDTO dto) {
        return sshSourceDAO.updateSshSource(dto);
    }
    
    public int saveSshSource(SshSourceDTO dto) {
        if (dto.getId() > 0) {
            return updateSshSource(dto);
        }
        return insertSshSource(dto);
    }

    public int saveSshSource(SshSourceDTO dto, Map<String, Object> paramMap) {
        SshSourceDTO obj = getSshSourceOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateSshSource(dto);
        }
         return insertSshSource(dto);
    }

    public int deleteSshSource(int id) {
        return sshSourceDAO.deleteSshSource(id);
    }

	public int deleteSshSource(SshSourceDTO dto) {
        return sshSourceDAO.deleteSshSources(dto);
    }

    public SshSourceDTO getSshSourceById(int id) {
        return sshSourceDAO.getSshSourceById(id);
    }
    
    public SshSourceDTO getSshSourceOne(Map<String, Object> paramMap) {
        return sshSourceDAO.getSshSourceOne(paramMap);
    }

    public List<SshSourceDTO> getSshSources(Map<String, Object> paramMap) {
        return sshSourceDAO.getSshSources(paramMap);
    }

    public PageOutObject<SshSourceDTO> getSshSourcesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<SshSourceDTO> list = sshSourceDAO.getSshSources(paramMap);
        int count = sshSourceDAO.getSshSourcesCount(paramMap);
        return new PageOutObject<SshSourceDTO>(count, list, page);
    }
    
    public int getSshSourcesCount(Map<String, Object> paramMap) {
        return sshSourceDAO.getSshSourcesCount(paramMap);
    }

}
