//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.struct.dao.HdfsPathDAO;
import com.tianji.r.biz.struct.service.HdfsPathService;
import com.tianji.r.biz.struct.model.HdfsPathDTO;

/**
 * This is HdfsPath Service implemention
 * @author Conan Zhang
 * @date 2013-03-27
 */
@Service(value="hdfsPathService")
public class HdfsPathServiceImpl extends SpringServiceImpl implements HdfsPathService {

    @Autowired
    HdfsPathDAO hdfsPathDAO;

    public int insertHdfsPath(HdfsPathDTO dto) {
        return hdfsPathDAO.insertHdfsPath(dto);
    }
    
    public int updateHdfsPath(HdfsPathDTO dto) {
        return hdfsPathDAO.updateHdfsPath(dto);
    }
    
    public int saveHdfsPath(HdfsPathDTO dto) {
        if (dto.getId() > 0) {
            return updateHdfsPath(dto);
        }
        return insertHdfsPath(dto);
    }

    public int saveHdfsPath(HdfsPathDTO dto, Map<String, Object> paramMap) {
        HdfsPathDTO obj = getHdfsPathOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateHdfsPath(dto);
        }
         return insertHdfsPath(dto);
    }

    public int deleteHdfsPath(int id) {
        return hdfsPathDAO.deleteHdfsPath(id);
    }

	public int deleteHdfsPath(HdfsPathDTO dto) {
        return hdfsPathDAO.deleteHdfsPaths(dto);
    }

    public HdfsPathDTO getHdfsPathById(int id) {
        return hdfsPathDAO.getHdfsPathById(id);
    }
    
    public HdfsPathDTO getHdfsPathOne(Map<String, Object> paramMap) {
        return hdfsPathDAO.getHdfsPathOne(paramMap);
    }

    public List<HdfsPathDTO> getHdfsPaths(Map<String, Object> paramMap) {
        return hdfsPathDAO.getHdfsPaths(paramMap);
    }

    public PageOutObject<HdfsPathDTO> getHdfsPathsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<HdfsPathDTO> list = hdfsPathDAO.getHdfsPaths(paramMap);
        int count = hdfsPathDAO.getHdfsPathsCount(paramMap);
        return new PageOutObject<HdfsPathDTO>(count, list, page);
    }
    
    public int getHdfsPathsCount(Map<String, Object> paramMap) {
        return hdfsPathDAO.getHdfsPathsCount(paramMap);
    }

}
