//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.DbtableOutDAO;
import com.tianji.r.biz.struct.service.DbtableOutService;
import com.tianji.r.biz.struct.model.DbtableOutDTO;

/**
 * This is DbtableOut Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="dbtableOutService")
public class DbtableOutServiceImpl extends SpringServiceImpl implements DbtableOutService {

    @Autowired
    DbtableOutDAO dbtableOutDAO;

    public int insertDbtableOut(DbtableOutDTO dto) {
        return dbtableOutDAO.insertDbtableOut(dto);
    }
    
    public int updateDbtableOut(DbtableOutDTO dto) {
        return dbtableOutDAO.updateDbtableOut(dto);
    }
    
    public int saveDbtableOut(DbtableOutDTO dto) {
        if (dto.getId() > 0) {
            return updateDbtableOut(dto);
        }
        return insertDbtableOut(dto);
    }

    public int saveDbtableOut(DbtableOutDTO dto, Map<String, Object> paramMap) {
        DbtableOutDTO obj = getDbtableOutOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateDbtableOut(dto);
        }
         return insertDbtableOut(dto);
    }

    public int deleteDbtableOut(int id) {
        return dbtableOutDAO.deleteDbtableOut(id);
    }

	public int deleteDbtableOut(DbtableOutDTO dto) {
        return dbtableOutDAO.deleteDbtableOuts(dto);
    }

    public DbtableOutDTO getDbtableOutById(int id) {
        return dbtableOutDAO.getDbtableOutById(id);
    }
    
    public DbtableOutDTO getDbtableOutOne(Map<String, Object> paramMap) {
        return dbtableOutDAO.getDbtableOutOne(paramMap);
    }

    public List<DbtableOutDTO> getDbtableOuts(Map<String, Object> paramMap) {
        return dbtableOutDAO.getDbtableOuts(paramMap);
    }

    public PageOutObject<DbtableOutDTO> getDbtableOutsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<DbtableOutDTO> list = dbtableOutDAO.getDbtableOuts(paramMap);
        int count = dbtableOutDAO.getDbtableOutsCount(paramMap);
        return new PageOutObject<DbtableOutDTO>(count, list, page);
    }
    
    public int getDbtableOutsCount(Map<String, Object> paramMap) {
        return dbtableOutDAO.getDbtableOutsCount(paramMap);
    }

}
