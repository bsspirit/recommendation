//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.DbtableConfDTO;

/**
 * This is DbtableConf DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface DbtableConfDAO extends MybatisDAO {

    int insertDbtableConf(DbtableConfDTO dto);
    int updateDbtableConf(DbtableConfDTO dto);
    int deleteDbtableConf(int id);
    int deleteDbtableConfs (DbtableConfDTO dto);

    DbtableConfDTO getDbtableConfById(int id);
    DbtableConfDTO getDbtableConfOne(Map<String,Object> paramMap);
    List<DbtableConfDTO> getDbtableConfs(Map<String,Object> paramMap);
    int getDbtableConfsCount(Map<String,Object> paramMap);
}

