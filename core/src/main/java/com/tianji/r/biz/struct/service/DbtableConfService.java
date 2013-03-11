//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.DbtableConfDTO;

/**
 * This is DbtableConf DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface DbtableConfService extends SpringService {

    int insertDbtableConf(DbtableConfDTO dto);
    int updateDbtableConf(DbtableConfDTO dto);
    int saveDbtableConf(DbtableConfDTO dto);
    int saveDbtableConf(DbtableConfDTO dto, Map<String,Object> paramMap);
    int deleteDbtableConf(int id);
    int deleteDbtableConf(DbtableConfDTO dto);
    

    DbtableConfDTO getDbtableConfById(int id);
    DbtableConfDTO getDbtableConfOne(Map<String,Object> paramMap);
    List<DbtableConfDTO> getDbtableConfs(Map<String,Object> paramMap);
    PageOutObject<DbtableConfDTO> getDbtableConfsPaging(Map<String,Object> paramMap, PageInObject page);
    int getDbtableConfsCount(Map<String,Object> paramMap);
}

