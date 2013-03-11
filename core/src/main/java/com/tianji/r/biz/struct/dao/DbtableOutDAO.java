//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.DbtableOutDTO;

/**
 * This is DbtableOut DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface DbtableOutDAO extends MybatisDAO {

    int insertDbtableOut(DbtableOutDTO dto);
    int updateDbtableOut(DbtableOutDTO dto);
    int deleteDbtableOut(int id);
    int deleteDbtableOuts (DbtableOutDTO dto);

    DbtableOutDTO getDbtableOutById(int id);
    DbtableOutDTO getDbtableOutOne(Map<String,Object> paramMap);
    List<DbtableOutDTO> getDbtableOuts(Map<String,Object> paramMap);
    int getDbtableOutsCount(Map<String,Object> paramMap);
}

