//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.source.dao.TransportSourceDAO;
import com.tianji.r.biz.source.service.TransportSourceService;
import com.tianji.r.biz.source.model.TransportSourceDTO;

/**
 * This is TransportSource Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="transportSourceService")
public class TransportSourceServiceImpl extends SpringServiceImpl implements TransportSourceService {

    @Autowired
    TransportSourceDAO transportSourceDAO;

    public int insertTransportSource(TransportSourceDTO dto) {
        return transportSourceDAO.insertTransportSource(dto);
    }
    
    public int updateTransportSource(TransportSourceDTO dto) {
        return transportSourceDAO.updateTransportSource(dto);
    }
    
    public int saveTransportSource(TransportSourceDTO dto) {
        if (dto.getId() > 0) {
            return updateTransportSource(dto);
        }
        return insertTransportSource(dto);
    }

    public int saveTransportSource(TransportSourceDTO dto, Map<String, Object> paramMap) {
        TransportSourceDTO obj = getTransportSourceOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateTransportSource(dto);
        }
         return insertTransportSource(dto);
    }

    public int deleteTransportSource(int id) {
        return transportSourceDAO.deleteTransportSource(id);
    }

	public int deleteTransportSource(TransportSourceDTO dto) {
        return transportSourceDAO.deleteTransportSources(dto);
    }

    public TransportSourceDTO getTransportSourceById(int id) {
        return transportSourceDAO.getTransportSourceById(id);
    }
    
    public TransportSourceDTO getTransportSourceOne(Map<String, Object> paramMap) {
        return transportSourceDAO.getTransportSourceOne(paramMap);
    }

    public List<TransportSourceDTO> getTransportSources(Map<String, Object> paramMap) {
        return transportSourceDAO.getTransportSources(paramMap);
    }

    public PageOutObject<TransportSourceDTO> getTransportSourcesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<TransportSourceDTO> list = transportSourceDAO.getTransportSources(paramMap);
        int count = transportSourceDAO.getTransportSourcesCount(paramMap);
        return new PageOutObject<TransportSourceDTO>(count, list, page);
    }
    
    public int getTransportSourcesCount(Map<String, Object> paramMap) {
        return transportSourceDAO.getTransportSourcesCount(paramMap);
    }

}
