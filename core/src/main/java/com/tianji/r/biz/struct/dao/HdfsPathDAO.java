//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.struct.model.HdfsPathDTO;

/**
 * This is HdfsPath DAO interface
 * @author Conan Zhang
 * @date 2013-03-27
 */
public interface HdfsPathDAO extends MybatisDAO {

    int insertHdfsPath(HdfsPathDTO dto);
    int updateHdfsPath(HdfsPathDTO dto);
    int deleteHdfsPath(int id);
    int deleteHdfsPaths (HdfsPathDTO dto);

    HdfsPathDTO getHdfsPathById(int id);
    HdfsPathDTO getHdfsPathOne(Map<String,Object> paramMap);
    List<HdfsPathDTO> getHdfsPaths(Map<String,Object> paramMap);
    int getHdfsPathsCount(Map<String,Object> paramMap);
}

