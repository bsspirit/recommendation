//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.struct.model.HdfsPathDTO;

/**
 * This is HdfsPath DAO interface
 * @author Conan Zhang
 * @date 2013-03-27
 */
public interface HdfsPathService extends SpringService {

    int insertHdfsPath(HdfsPathDTO dto);
    int updateHdfsPath(HdfsPathDTO dto);
    int saveHdfsPath(HdfsPathDTO dto);
    int saveHdfsPath(HdfsPathDTO dto, Map<String,Object> paramMap);
    int deleteHdfsPath(int id);
    int deleteHdfsPath(HdfsPathDTO dto);
    

    HdfsPathDTO getHdfsPathById(int id);
    HdfsPathDTO getHdfsPathOne(Map<String,Object> paramMap);
    List<HdfsPathDTO> getHdfsPaths(Map<String,Object> paramMap);
    PageOutObject<HdfsPathDTO> getHdfsPathsPaging(Map<String,Object> paramMap, PageInObject page);
    int getHdfsPathsCount(Map<String,Object> paramMap);
}

