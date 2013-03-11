//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.job.model.JobDTO;

/**
 * This is Job DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobService extends SpringService {

    int insertJob(JobDTO dto);
    int updateJob(JobDTO dto);
    int saveJob(JobDTO dto);
    int saveJob(JobDTO dto, Map<String,Object> paramMap);
    int deleteJob(int id);
    int deleteJob(JobDTO dto);
    

    JobDTO getJobById(int id);
    JobDTO getJobOne(Map<String,Object> paramMap);
    List<JobDTO> getJobs(Map<String,Object> paramMap);
    PageOutObject<JobDTO> getJobsPaging(Map<String,Object> paramMap, PageInObject page);
    int getJobsCount(Map<String,Object> paramMap);
}

