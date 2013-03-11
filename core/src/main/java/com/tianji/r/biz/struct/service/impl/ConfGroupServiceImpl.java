//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.ConfGroupDAO;
import com.tianji.r.biz.struct.service.ConfGroupService;
import com.tianji.r.biz.struct.model.ConfGroupDTO;

/**
 * This is ConfGroup Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="confGroupService")
public class ConfGroupServiceImpl extends SpringServiceImpl implements ConfGroupService {

    @Autowired
    ConfGroupDAO confGroupDAO;

    public int insertConfGroup(ConfGroupDTO dto) {
        return confGroupDAO.insertConfGroup(dto);
    }
    
    public int updateConfGroup(ConfGroupDTO dto) {
        return confGroupDAO.updateConfGroup(dto);
    }
    
    public int saveConfGroup(ConfGroupDTO dto) {
        if (dto.getId() > 0) {
            return updateConfGroup(dto);
        }
        return insertConfGroup(dto);
    }

    public int saveConfGroup(ConfGroupDTO dto, Map<String, Object> paramMap) {
        ConfGroupDTO obj = getConfGroupOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateConfGroup(dto);
        }
         return insertConfGroup(dto);
    }

    public int deleteConfGroup(int id) {
        return confGroupDAO.deleteConfGroup(id);
    }

	public int deleteConfGroup(ConfGroupDTO dto) {
        return confGroupDAO.deleteConfGroups(dto);
    }

    public ConfGroupDTO getConfGroupById(int id) {
        return confGroupDAO.getConfGroupById(id);
    }
    
    public ConfGroupDTO getConfGroupOne(Map<String, Object> paramMap) {
        return confGroupDAO.getConfGroupOne(paramMap);
    }

    public List<ConfGroupDTO> getConfGroups(Map<String, Object> paramMap) {
        return confGroupDAO.getConfGroups(paramMap);
    }

    public PageOutObject<ConfGroupDTO> getConfGroupsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<ConfGroupDTO> list = confGroupDAO.getConfGroups(paramMap);
        int count = confGroupDAO.getConfGroupsCount(paramMap);
        return new PageOutObject<ConfGroupDTO>(count, list, page);
    }
    
    public int getConfGroupsCount(Map<String, Object> paramMap) {
        return confGroupDAO.getConfGroupsCount(paramMap);
    }

}
