//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.DbtableOutDTO;

/**
 * This is DbtableOut DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface DbtableOutService extends SpringService {

    int insertDbtableOut(DbtableOutDTO dto);
    int updateDbtableOut(DbtableOutDTO dto);
    int saveDbtableOut(DbtableOutDTO dto);
    int saveDbtableOut(DbtableOutDTO dto, Map<String,Object> paramMap);
    int deleteDbtableOut(int id);
    int deleteDbtableOut(DbtableOutDTO dto);
    

    DbtableOutDTO getDbtableOutById(int id);
    DbtableOutDTO getDbtableOutOne(Map<String,Object> paramMap);
    List<DbtableOutDTO> getDbtableOuts(Map<String,Object> paramMap);
    PageOutObject<DbtableOutDTO> getDbtableOutsPaging(Map<String,Object> paramMap, PageInObject page);
    int getDbtableOutsCount(Map<String,Object> paramMap);
}

