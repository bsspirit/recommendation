//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.job.dao.JobDAO;
import com.tianji.r.biz.job.service.JobService;
import com.tianji.r.biz.job.model.JobDTO;

/**
 * This is Job Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="jobService")
public class JobServiceImpl extends SpringServiceImpl implements JobService {

    @Autowired
    JobDAO jobDAO;

    public int insertJob(JobDTO dto) {
        return jobDAO.insertJob(dto);
    }
    
    public int updateJob(JobDTO dto) {
        return jobDAO.updateJob(dto);
    }
    
    public int saveJob(JobDTO dto) {
        if (dto.getId() > 0) {
            return updateJob(dto);
        }
        return insertJob(dto);
    }

    public int saveJob(JobDTO dto, Map<String, Object> paramMap) {
        JobDTO obj = getJobOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateJob(dto);
        }
         return insertJob(dto);
    }

    public int deleteJob(int id) {
        return jobDAO.deleteJob(id);
    }

	public int deleteJob(JobDTO dto) {
        return jobDAO.deleteJobs(dto);
    }

    public JobDTO getJobById(int id) {
        return jobDAO.getJobById(id);
    }
    
    public JobDTO getJobOne(Map<String, Object> paramMap) {
        return jobDAO.getJobOne(paramMap);
    }

    public List<JobDTO> getJobs(Map<String, Object> paramMap) {
        return jobDAO.getJobs(paramMap);
    }

    public PageOutObject<JobDTO> getJobsPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<JobDTO> list = jobDAO.getJobs(paramMap);
        int count = jobDAO.getJobsCount(paramMap);
        return new PageOutObject<JobDTO>(count, list, page);
    }
    
    public int getJobsCount(Map<String, Object> paramMap) {
        return jobDAO.getJobsCount(paramMap);
    }

}
