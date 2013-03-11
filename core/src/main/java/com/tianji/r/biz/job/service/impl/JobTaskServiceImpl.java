//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.conan.base.service.SpringServiceImpl;
import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;

import com.tianji.r.biz.job.dao.JobTaskDAO;
import com.tianji.r.biz.job.service.JobTaskService;
import com.tianji.r.biz.job.model.JobTaskDTO;

/**
 * This is JobTask Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="jobTaskService")
public class JobTaskServiceImpl extends SpringServiceImpl implements JobTaskService {

    @Autowired
    JobTaskDAO jobTaskDAO;

    public int insertJobTask(JobTaskDTO dto) {
        return jobTaskDAO.insertJobTask(dto);
    }
    
    public int updateJobTask(JobTaskDTO dto) {
        return jobTaskDAO.updateJobTask(dto);
    }
    
    public int saveJobTask(JobTaskDTO dto) {
        if (dto.getId() > 0) {
            return updateJobTask(dto);
        }
        return insertJobTask(dto);
    }

    public int saveJobTask(JobTaskDTO dto, Map<String, Object> paramMap) {
        JobTaskDTO obj = getJobTaskOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateJobTask(dto);
        }
         return insertJobTask(dto);
    }

    public int deleteJobTask(int id) {
        return jobTaskDAO.deleteJobTask(id);
    }

	public int deleteJobTask(JobTaskDTO dto) {
        return jobTaskDAO.deleteJobTasks(dto);
    }

    public JobTaskDTO getJobTaskById(int id) {
        return jobTaskDAO.getJobTaskById(id);
    }
    
    public JobTaskDTO getJobTaskOne(Map<String, Object> paramMap) {
        return jobTaskDAO.getJobTaskOne(paramMap);
    }

    public List<JobTaskDTO> getJobTasks(Map<String, Object> paramMap) {
        return jobTaskDAO.getJobTasks(paramMap);
    }

    public PageOutObject<JobTaskDTO> getJobTasksPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<JobTaskDTO> list = jobTaskDAO.getJobTasks(paramMap);
        int count = jobTaskDAO.getJobTasksCount(paramMap);
        return new PageOutObject<JobTaskDTO>(count, list, page);
    }
    
    public int getJobTasksCount(Map<String, Object> paramMap) {
        return jobTaskDAO.getJobTasksCount(paramMap);
    }

}
