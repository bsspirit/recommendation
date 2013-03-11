//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.DbtableDTO;

/**
 * This is Dbtable DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface DbtableDAO extends MybatisDAO {

    int insertDbtable(DbtableDTO dto);
    int updateDbtable(DbtableDTO dto);
    int deleteDbtable(int id);
    int deleteDbtables (DbtableDTO dto);

    DbtableDTO getDbtableById(int id);
    DbtableDTO getDbtableOne(Map<String,Object> paramMap);
    List<DbtableDTO> getDbtables(Map<String,Object> paramMap);
    int getDbtablesCount(Map<String,Object> paramMap);
}

