//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.DbtableConfDAO;
import com.tianji.r.biz.struct.service.DbtableConfService;
import com.tianji.r.biz.struct.model.DbtableConfDTO;

/**
 * This is DbtableConf Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="dbtableConfService")
public class DbtableConfServiceImpl extends SpringServiceImpl implements DbtableConfService {

    @Autowired
    DbtableConfDAO dbtableConfDAO;

    public int insertDbtableConf(DbtableConfDTO dto) {
        return dbtableConfDAO.insertDbtableConf(dto);
    }
    
    public int updateDbtableConf(DbtableConfDTO dto) {
        return dbtableConfDAO.updateDbtableConf(dto);
    }
    
    public int saveDbtableConf(DbtableConfDTO dto) {
        if (dto.getId() > 0) {
            return updateDbtableConf(dto);
        }
        return insertDbtableConf(dto);
    }

    public int saveDbtableConf(DbtableConfDTO dto, Map<String, Object> paramMap) {
        DbtableConfDTO obj = getDbtableConfOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateDbtableConf(dto);
        }
         return insertDbtableConf(dto);
    }

    public int deleteDbtableConf(int id) {
        return dbtableConfDAO.deleteDbtableConf(id);
    }

	public int deleteDbtableConf(DbtableConfDTO dto) {
        return dbtableConfDAO.deleteDbtableConfs(dto);
    }

    public DbtableConfDTO getDbtableConfById(int id) {
        return dbtableConfDAO.getDbtableConfById(id);
    }
    
    public DbtableConfDTO getDbtableConfOne(Map<String, Object> paramMap) {
        return dbtableConfDAO.getDbtableConfOne(paramMap);
    }

    public List<DbtableConfDTO> getDbtableConfs(Map<String, Object> paramMap) {
        return dbtableConfDAO.getDbtableConfs(paramMap);
    }

    public PageOutObject<DbtableConfDTO> getDbtableConfsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<DbtableConfDTO> list = dbtableConfDAO.getDbtableConfs(paramMap);
        int count = dbtableConfDAO.getDbtableConfsCount(paramMap);
        return new PageOutObject<DbtableConfDTO>(count, list, page);
    }
    
    public int getDbtableConfsCount(Map<String, Object> paramMap) {
        return dbtableConfDAO.getDbtableConfsCount(paramMap);
    }

}
