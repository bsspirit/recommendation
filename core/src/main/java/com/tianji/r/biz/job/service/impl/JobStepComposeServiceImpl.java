//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.service.impl;

import java.util.List;
import java.util.Map;

import org.conan.base.service.PageInObject;
import org.conan.base.service.PageOutObject;
import org.conan.base.service.SpringServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.biz.job.dao.JobStepComposeDAO;
import com.tianji.r.biz.job.model.JobStepComposeDTO;
import com.tianji.r.biz.job.service.JobStepComposeService;

/**
 * This is JobStepCompose Service implemention
 * @author Conan Zhang
 * @date 2013-03-11
 */
@Service(value="jobStepComposeService")
public class JobStepComposeServiceImpl extends SpringServiceImpl implements JobStepComposeService {

    @Autowired
    JobStepComposeDAO jobStepComposeDAO;

    public int insertJobStepCompose(JobStepComposeDTO dto) {
        return jobStepComposeDAO.insertJobStepCompose(dto);
    }
    
    public int updateJobStepCompose(JobStepComposeDTO dto) {
        return jobStepComposeDAO.updateJobStepCompose(dto);
    }
    
    public int saveJobStepCompose(JobStepComposeDTO dto) {
        if (dto.getId() > 0) {
            return updateJobStepCompose(dto);
        }
        return insertJobStepCompose(dto);
    }

    public int saveJobStepCompose(JobStepComposeDTO dto, Map<String, Object> paramMap) {
        JobStepComposeDTO obj = getJobStepComposeOne(paramMap);
        if (obj != null) {
            dto.setId(obj.getId());
            return updateJobStepCompose(dto);
        }
         return insertJobStepCompose(dto);
    }

    public int deleteJobStepCompose(int id) {
        return jobStepComposeDAO.deleteJobStepCompose(id);
    }

	public int deleteJobStepCompose(JobStepComposeDTO dto) {
        return jobStepComposeDAO.deleteJobStepComposes(dto);
    }

    public JobStepComposeDTO getJobStepComposeById(int id) {
        return jobStepComposeDAO.getJobStepComposeById(id);
    }
    
    public JobStepComposeDTO getJobStepComposeOne(Map<String, Object> paramMap) {
        return jobStepComposeDAO.getJobStepComposeOne(paramMap);
    }

    public List<JobStepComposeDTO> getJobStepComposes(Map<String, Object> paramMap) {
        return jobStepComposeDAO.getJobStepComposes(paramMap);
    }

    public PageOutObject<JobStepComposeDTO> getJobStepComposesPaging(Map<String, Object> paramMap, PageInObject page) {
        paramMap.put("page", page);
        List<JobStepComposeDTO> list = jobStepComposeDAO.getJobStepComposes(paramMap);
        int count = jobStepComposeDAO.getJobStepComposesCount(paramMap);
        return new PageOutObject<JobStepComposeDTO>(count, list, page);
    }
    
    public int getJobStepComposesCount(Map<String, Object> paramMap) {
        return jobStepComposeDAO.getJobStepComposesCount(paramMap);
    }

    @Override
    public String getFirstJobStepName(Map<String, Object> paramMap) throws Exception {
        List<JobStepComposeDTO> list = getJobStepComposes(paramMap);
        for (JobStepComposeDTO jobStepComposeDTO : list) {
            if (jobStepComposeDTO.getStepType() == 1) {
                return jobStepComposeDTO.getJobStepRef();
            }
        }
        throw new Exception("No First Job Step");
    }

}
