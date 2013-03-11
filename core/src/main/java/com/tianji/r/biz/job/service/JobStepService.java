//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.job.model.JobStepDTO;

/**
 * This is JobStep DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobStepService extends SpringService {

    int insertJobStep(JobStepDTO dto);
    int updateJobStep(JobStepDTO dto);
    int saveJobStep(JobStepDTO dto);
    int saveJobStep(JobStepDTO dto, Map<String,Object> paramMap);
    int deleteJobStep(int id);
    int deleteJobStep(JobStepDTO dto);
    

    JobStepDTO getJobStepById(int id);
    JobStepDTO getJobStepOne(Map<String,Object> paramMap);
    List<JobStepDTO> getJobSteps(Map<String,Object> paramMap);
    PageOutObject<JobStepDTO> getJobStepsPaging(Map<String,Object> paramMap, PageInObject page);
    int getJobStepsCount(Map<String,Object> paramMap);
}

