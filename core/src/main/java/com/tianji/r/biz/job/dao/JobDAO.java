//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.job.model.JobDTO;

/**
 * This is Job DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobDAO extends MybatisDAO {

    int insertJob(JobDTO dto);
    int updateJob(JobDTO dto);
    int deleteJob(int id);
    int deleteJobs (JobDTO dto);

    JobDTO getJobById(int id);
    JobDTO getJobOne(Map<String,Object> paramMap);
    List<JobDTO> getJobs(Map<String,Object> paramMap);
    int getJobsCount(Map<String,Object> paramMap);
}

