//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.ConfGroupDTO;

/**
 * This is ConfGroup DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface ConfGroupService extends SpringService {

    int insertConfGroup(ConfGroupDTO dto);
    int updateConfGroup(ConfGroupDTO dto);
    int saveConfGroup(ConfGroupDTO dto);
    int saveConfGroup(ConfGroupDTO dto, Map<String,Object> paramMap);
    int deleteConfGroup(int id);
    int deleteConfGroup(ConfGroupDTO dto);
    

    ConfGroupDTO getConfGroupById(int id);
    ConfGroupDTO getConfGroupOne(Map<String,Object> paramMap);
    List<ConfGroupDTO> getConfGroups(Map<String,Object> paramMap);
    PageOutObject<ConfGroupDTO> getConfGroupsPaging(Map<String,Object> paramMap, PageInObject page);
    int getConfGroupsCount(Map<String,Object> paramMap);
}

