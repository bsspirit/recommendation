//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service;

import java.util.List;
import java.util.Map;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringService;

import com.tianji.r.biz.job.model.JobTaskDTO;

/**
 * This is JobTask DAO interface
 * @author Conan Zhang
 * @date 2013-03-11
 */
public interface JobTaskService extends SpringService {

    int insertJobTask(JobTaskDTO dto);
    int updateJobTask(JobTaskDTO dto);
    int saveJobTask(JobTaskDTO dto);
    int saveJobTask(JobTaskDTO dto, Map<String,Object> paramMap);
    int deleteJobTask(int id);
    int deleteJobTask(JobTaskDTO dto);
    

    JobTaskDTO getJobTaskById(int id);
    JobTaskDTO getJobTaskOne(Map<String,Object> paramMap);
    List<JobTaskDTO> getJobTasks(Map<String,Object> paramMap);
    PageOutObject<JobTaskDTO> getJobTasksPaging(Map<String,Object> paramMap, PageInObject page);
    int getJobTasksCount(Map<String,Object> paramMap);
}

