//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.source.model.ScpSourceDTO;

/**
 * This is ScpSource DAO interface
 * @author Conan Zhang
 * @date 2013-03-08
 */
public interface ScpSourceDAO extends MybatisDAO {

    int insertScpSource(ScpSourceDTO dto);
    int updateScpSource(ScpSourceDTO dto);
    int deleteScpSource(int id);
    int deleteScpSources (ScpSourceDTO dto);

    ScpSourceDTO getScpSourceById(int id);
    ScpSourceDTO getScpSourceOne(Map<String,Object> paramMap);
    List<ScpSourceDTO> getScpSources(Map<String,Object> paramMap);
    int getScpSourcesCount(Map<String,Object> paramMap);
}

