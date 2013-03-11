//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.ConfGroupDTO;

/**
 * This is ConfGroup DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface ConfGroupDAO extends MybatisDAO {

    int insertConfGroup(ConfGroupDTO dto);
    int updateConfGroup(ConfGroupDTO dto);
    int deleteConfGroup(int id);
    int deleteConfGroups (ConfGroupDTO dto);

    ConfGroupDTO getConfGroupById(int id);
    ConfGroupDTO getConfGroupOne(Map<String,Object> paramMap);
    List<ConfGroupDTO> getConfGroups(Map<String,Object> paramMap);
    int getConfGroupsCount(Map<String,Object> paramMap);
}

