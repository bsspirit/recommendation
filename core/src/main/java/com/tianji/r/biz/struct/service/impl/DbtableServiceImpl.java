//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.DbtableDAO;
import com.tianji.r.biz.struct.service.DbtableService;
import com.tianji.r.biz.struct.model.DbtableDTO;

/**
 * This is Dbtable Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="dbtableService")
public class DbtableServiceImpl extends SpringServiceImpl implements DbtableService {

    @Autowired
    DbtableDAO dbtableDAO;

    public int insertDbtable(DbtableDTO dto) {
        return dbtableDAO.insertDbtable(dto);
    }
    
    public int updateDbtable(DbtableDTO dto) {
        return dbtableDAO.updateDbtable(dto);
    }
    
    public int saveDbtable(DbtableDTO dto) {
        if (dto.getId() > 0) {
            return updateDbtable(dto);
        }
        return insertDbtable(dto);
    }

    public int saveDbtable(DbtableDTO dto, Map<String, Object> paramMap) {
        DbtableDTO obj = getDbtableOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateDbtable(dto);
        }
         return insertDbtable(dto);
    }

    public int deleteDbtable(int id) {
        return dbtableDAO.deleteDbtable(id);
    }

	public int deleteDbtable(DbtableDTO dto) {
        return dbtableDAO.deleteDbtables(dto);
    }

    public DbtableDTO getDbtableById(int id) {
        return dbtableDAO.getDbtableById(id);
    }
    
    public DbtableDTO getDbtableOne(Map<String, Object> paramMap) {
        return dbtableDAO.getDbtableOne(paramMap);
    }

    public List<DbtableDTO> getDbtables(Map<String, Object> paramMap) {
        return dbtableDAO.getDbtables(paramMap);
    }

    public PageOutObject<DbtableDTO> getDbtablesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<DbtableDTO> list = dbtableDAO.getDbtables(paramMap);
        int count = dbtableDAO.getDbtablesCount(paramMap);
        return new PageOutObject<DbtableDTO>(count, list, page);
    }
    
    public int getDbtablesCount(Map<String, Object> paramMap) {
        return dbtableDAO.getDbtablesCount(paramMap);
    }

}
