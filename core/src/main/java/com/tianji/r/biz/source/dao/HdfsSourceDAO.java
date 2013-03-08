//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.source.model.HdfsSourceDTO;

/**
 * This is HdfsSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface HdfsSourceDAO extends MybatisDAO {

    int insertHdfsSource(HdfsSourceDTO dto);
    int updateHdfsSource(HdfsSourceDTO dto);
    int deleteHdfsSource(int id);
    int deleteHdfsSources (HdfsSourceDTO dto);

    HdfsSourceDTO getHdfsSourceById(int id);
    HdfsSourceDTO getHdfsSourceOne(Map<String,Object> paramMap);
    List<HdfsSourceDTO> getHdfsSources(Map<String,Object> paramMap);
    int getHdfsSourcesCount(Map<String,Object> paramMap);
}

