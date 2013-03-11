//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.job.model.JobStepComposeDTO;

/**
 * This is JobStepCompose DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobStepComposeDAO extends MybatisDAO {

    int insertJobStepCompose(JobStepComposeDTO dto);
    int updateJobStepCompose(JobStepComposeDTO dto);
    int deleteJobStepCompose(int id);
    int deleteJobStepComposes (JobStepComposeDTO dto);

    JobStepComposeDTO getJobStepComposeById(int id);
    JobStepComposeDTO getJobStepComposeOne(Map<String,Object> paramMap);
    List<JobStepComposeDTO> getJobStepComposes(Map<String,Object> paramMap);
    int getJobStepComposesCount(Map<String,Object> paramMap);
}

