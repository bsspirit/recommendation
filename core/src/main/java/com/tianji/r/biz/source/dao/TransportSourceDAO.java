//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.source.model.TransportSourceDTO;

/**
 * This is TransportSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface TransportSourceDAO extends MybatisDAO {

    int insertTransportSource(TransportSourceDTO dto);
    int updateTransportSource(TransportSourceDTO dto);
    int deleteTransportSource(int id);
    int deleteTransportSources (TransportSourceDTO dto);

    TransportSourceDTO getTransportSourceById(int id);
    TransportSourceDTO getTransportSourceOne(Map<String,Object> paramMap);
    List<TransportSourceDTO> getTransportSources(Map<String,Object> paramMap);
    int getTransportSourcesCount(Map<String,Object> paramMap);
}

