//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.job.model.JobStepDTO;

/**
 * This is JobStep DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobStepDAO extends MybatisDAO {

    int insertJobStep(JobStepDTO dto);
    int updateJobStep(JobStepDTO dto);
    int deleteJobStep(int id);
    int deleteJobSteps (JobStepDTO dto);

    JobStepDTO getJobStepById(int id);
    JobStepDTO getJobStepOne(Map<String,Object> paramMap);
    List<JobStepDTO> getJobSteps(Map<String,Object> paramMap);
    int getJobStepsCount(Map<String,Object> paramMap);
}

