//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.job.dao.JobStepDAO;
import com.tianji.r.biz.job.service.JobStepService;
import com.tianji.r.biz.job.model.JobStepDTO;

/**
 * This is JobStep Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="jobStepService")
public class JobStepServiceImpl extends SpringServiceImpl implements JobStepService {

    @Autowired
    JobStepDAO jobStepDAO;

    public int insertJobStep(JobStepDTO dto) {
        return jobStepDAO.insertJobStep(dto);
    }
    
    public int updateJobStep(JobStepDTO dto) {
        return jobStepDAO.updateJobStep(dto);
    }
    
    public int saveJobStep(JobStepDTO dto) {
        if (dto.getId() > 0) {
            return updateJobStep(dto);
        }
        return insertJobStep(dto);
    }

    public int saveJobStep(JobStepDTO dto, Map<String, Object> paramMap) {
        JobStepDTO obj = getJobStepOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateJobStep(dto);
        }
         return insertJobStep(dto);
    }

    public int deleteJobStep(int id) {
        return jobStepDAO.deleteJobStep(id);
    }

	public int deleteJobStep(JobStepDTO dto) {
        return jobStepDAO.deleteJobSteps(dto);
    }

    public JobStepDTO getJobStepById(int id) {
        return jobStepDAO.getJobStepById(id);
    }
    
    public JobStepDTO getJobStepOne(Map<String, Object> paramMap) {
        return jobStepDAO.getJobStepOne(paramMap);
    }

    public List<JobStepDTO> getJobSteps(Map<String, Object> paramMap) {
        return jobStepDAO.getJobSteps(paramMap);
    }

    public PageOutObject<JobStepDTO> getJobStepsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<JobStepDTO> list = jobStepDAO.getJobSteps(paramMap);
        int count = jobStepDAO.getJobStepsCount(paramMap);
        return new PageOutObject<JobStepDTO>(count, list, page);
    }
    
    public int getJobStepsCount(Map<String, Object> paramMap) {
        return jobStepDAO.getJobStepsCount(paramMap);
    }

}
