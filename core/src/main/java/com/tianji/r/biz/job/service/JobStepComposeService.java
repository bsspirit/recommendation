//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service;

import java.util.List;
import java.util.Map;

import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.job.model.JobStepComposeDTO;

/**
 * This is JobStepCompose DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobStepComposeService extends SpringService {

    int insertJobStepCompose(JobStepComposeDTO dto);
    int updateJobStepCompose(JobStepComposeDTO dto);
    int saveJobStepCompose(JobStepComposeDTO dto);
    int saveJobStepCompose(JobStepComposeDTO dto, Map<String,Object> paramMap);
    int deleteJobStepCompose(int id);
    int deleteJobStepCompose(JobStepComposeDTO dto);
    
    JobStepComposeDTO getJobStepComposeById(int id);
    JobStepComposeDTO getJobStepComposeOne(Map<String,Object> paramMap);
    List<JobStepComposeDTO> getJobStepComposes(Map<String,Object> paramMap);
    PageOutObject<JobStepComposeDTO> getJobStepComposesPaging(Map<String,Object> paramMap, PageInObject page);
    int getJobStepComposesCount(Map<String,Object> paramMap);
    
    /**
     * First Job Step Name 
     */
    String getFirstJobStepName(Map<String, Object> paramMap) throws Exception;
}

