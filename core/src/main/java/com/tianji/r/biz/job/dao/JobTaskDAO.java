//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.dao;

import java.util.List;
import java.util.Map;
import org.conan.base.dao.MybatisDAO;

import com.tianji.r.biz.job.model.JobTaskDTO;

/**
 * This is JobTask DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobTaskDAO extends MybatisDAO {

    int insertJobTask(JobTaskDTO dto);
    int updateJobTask(JobTaskDTO dto);
    int deleteJobTask(int id);
    int deleteJobTasks (JobTaskDTO dto);

    JobTaskDTO getJobTaskById(int id);
    JobTaskDTO getJobTaskOne(Map<String,Object> paramMap);
    List<JobTaskDTO> getJobTasks(Map<String,Object> paramMap);
    int getJobTasksCount(Map<String,Object> paramMap);
}

