package com.tianji.r.core.conf.meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tianji.r.biz.job.model.JobStepDTO;
import com.tianji.r.biz.job.model.JobTaskDTO;
import com.tianji.r.biz.job.service.JobStepService;
import com.tianji.r.biz.job.service.JobTaskService;
import com.tianji.r.biz.source.model.DatabaseSourceDTO;
import com.tianji.r.biz.source.model.HdfsSourceDTO;
import com.tianji.r.biz.source.model.HiveSourceDTO;
import com.tianji.r.biz.source.model.ScpSourceDTO;
import com.tianji.r.biz.source.model.SshSourceDTO;
import com.tianji.r.biz.source.model.TransportSourceDTO;
import com.tianji.r.biz.source.service.DatabaseSourceService;
import com.tianji.r.biz.source.service.HdfsSourceService;
import com.tianji.r.biz.source.service.HiveSourceService;
import com.tianji.r.biz.source.service.ScpSourceService;
import com.tianji.r.biz.source.service.SshSourceService;
import com.tianji.r.biz.source.service.TransportSourceService;
import com.tianji.r.biz.struct.model.ConfGroupDTO;
import com.tianji.r.biz.struct.model.DbtableConfDTO;
import com.tianji.r.biz.struct.model.DbtableDTO;
import com.tianji.r.biz.struct.model.DbtableOutDTO;
import com.tianji.r.biz.struct.model.HdfsPathDTO;
import com.tianji.r.biz.struct.model.HiveTableDTO;
import com.tianji.r.biz.struct.model.MapRedAlgorithmDTO;
import com.tianji.r.biz.struct.service.ConfGroupService;
import com.tianji.r.biz.struct.service.DbtableConfService;
import com.tianji.r.biz.struct.service.DbtableOutService;
import com.tianji.r.biz.struct.service.DbtableService;
import com.tianji.r.biz.struct.service.HdfsPathService;
import com.tianji.r.biz.struct.service.HiveTableService;
import com.tianji.r.biz.struct.service.MapRedAlgorithmService;

@Service
public class LoadMetaData {

    @Autowired
    MetadataFactory metadataFactory;
    @Autowired
    DatabaseSourceService databaseSourceService;
    @Autowired
    ScpSourceService scpSourceService;
    @Autowired
    SshSourceService sshSourceService;
    @Autowired
    HdfsSourceService hdfsSourceService;
    @Autowired
    HiveSourceService hiveSourceService;
    @Autowired
    TransportSourceService transportSourceService;
    @Autowired
    DbtableOutService dbtableOutService;
    @Autowired
    DbtableService dbtableService;
    @Autowired
    DbtableConfService dbtableConfService;
    @Autowired
    ConfGroupService confGroupService;
    @Autowired
    JobTaskService jobTaskService;
    @Autowired
    JobStepService jobStepService;
    @Autowired
    HdfsPathService hdfsPathService;
    @Autowired
    HiveTableService hiveTableService;
    @Autowired
    MapRedAlgorithmService mapRedAlgorithmService;

    /**
     * TODO
     */
    public void createJobStep(String name) {// pymk_dbsync_DBTableExportStep
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("beanName", name);
        List<JobStepDTO> list = jobStepService.getJobSteps(paramMap);
        for (JobStepDTO dto : list) {
            System.out.println(dto);
            metadataFactory.createJobStep(dto);
        }
    }

    /**
     * TODO
     */
    public void createJobTask(String name) {// pymk_dbsync_DBTableExportTask
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("beanName", name);
        List<JobTaskDTO> list = jobTaskService.getJobTasks(paramMap);
        for (JobTaskDTO dto : list) {
            metadataFactory.createJobTask(dto);
        }
    }

    public void createMapRedAlgorithm(String name) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("beanName", name);
        MapRedAlgorithmDTO dto = mapRedAlgorithmService.getMapRedAlgorithmOne(paramMap);
        metadataFactory.createMapRedAlgorithm(dto);
    }

    public void createConfGroup(String groupName) {// dbSyncConfList
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("groupName", groupName);
        List<ConfGroupDTO> list = confGroupService.getConfGroups(paramMap);
        metadataFactory.createConfGroup(list);
    }

    public void createHiveTable() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<HiveTableDTO> list = hiveTableService.getHiveTables(paramMap);
        for (HiveTableDTO dto : list) {
            metadataFactory.createHiveTable(dto);
        }
    }

    public void createHdfsPath() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<HdfsPathDTO> list = hdfsPathService.getHdfsPaths(paramMap);
        for (HdfsPathDTO dto : list) {
            metadataFactory.createHdfsPath(dto);
        }
    }

    public void createDBTableConf() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<DbtableConfDTO> list = dbtableConfService.getDbtableConfs(paramMap);
        for (DbtableConfDTO dto : list) {
            metadataFactory.createDBTableConf(dto);
        }
    }

    public void createDBTable() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<DbtableDTO> list = dbtableService.getDbtables(paramMap);
        for (DbtableDTO dto : list) {
            metadataFactory.createDBTable(dto);
        }
    }

    public void createDBTableOut() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<DbtableOutDTO> list = dbtableOutService.getDbtableOuts(paramMap);
        for (DbtableOutDTO dto : list) {
            metadataFactory.createDBTableOutFile(dto);
        }
    }

    public void createTransport() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<TransportSourceDTO> list = transportSourceService.getTransportSources(paramMap);
        for (TransportSourceDTO dto : list) {
            metadataFactory.createTransportModel(dto);
        }
    }

    public void createScpSource() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<ScpSourceDTO> list = scpSourceService.getScpSources(paramMap);
        for (ScpSourceDTO dto : list) {
            metadataFactory.createScpSource(dto);
        }
    }

    public void createSshSource() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<SshSourceDTO> list = sshSourceService.getSshSources(paramMap);
        for (SshSourceDTO dto : list) {
            metadataFactory.createSshSource(dto);
        }
    }

    public void createHdfsSource() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<HdfsSourceDTO> list = hdfsSourceService.getHdfsSources(paramMap);
        for (HdfsSourceDTO dto : list) {
            metadataFactory.createHdfsSource(dto);
        }
    }

    public void createHiveSource() {
        metadataFactory.createHiveTemplate();
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<HiveSourceDTO> list = hiveSourceService.getHiveSources(paramMap);
        for (HiveSourceDTO dto : list) {
            metadataFactory.createHiveSource(dto);
        }
    }

    public void createDataSource() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        List<DatabaseSourceDTO> list = databaseSourceService.getDatabaseSources(paramMap);
        for (DatabaseSourceDTO dto : list) {
            metadataFactory.createDataSource(dto);
        }
    }

    // @Autowired
    // JobStepComposeService jobStepComposeService;
    // @Autowired
    // JobService jobService;

    // private void createJob(String name) {// pymk_dbSyncJob
    // Map<String, Object> paramMap = new HashMap<String, Object>();
    // paramMap.put("beanName", name);
    // List<JobDTO> list = jobService.getJobs(paramMap);
    // for (JobDTO dto : list) {
    // System.out.println(dto);
    // metadataFactory.createJob(dto);
    // }
    // }
    //
    // private void createJobStepCompose(String name) {// pymk_dbSyncJob_1
    // Map<String, Object> paramMap = new HashMap<String, Object>();
    // paramMap.put("jobRef", name);
    // List<JobStepComposeDTO> list = jobStepComposeService.getJobStepComposes(paramMap);
    // metadataFactory.createJobStepCompose(list);
    // }
    //

}
