//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.DbtableDTO;

/**
 * This is Dbtable DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface DbtableService extends SpringService {

    int insertDbtable(DbtableDTO dto);
    int updateDbtable(DbtableDTO dto);
    int saveDbtable(DbtableDTO dto);
    int saveDbtable(DbtableDTO dto, Map<String,Object> paramMap);
    int deleteDbtable(int id);
    int deleteDbtable(DbtableDTO dto);
    

    DbtableDTO getDbtableById(int id);
    DbtableDTO getDbtableOne(Map<String,Object> paramMap);
    List<DbtableDTO> getDbtables(Map<String,Object> paramMap);
    PageOutObject<DbtableDTO> getDbtablesPaging(Map<String,Object> paramMap, PageInObject page);
    int getDbtablesCount(Map<String,Object> paramMap);
}

