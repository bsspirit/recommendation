package com.tianji.r.core.conf.meta;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveTemplate;
import org.springframework.stereotype.Service;

import com.tianji.r.biz.job.model.JobStepDTO;
import com.tianji.r.biz.job.model.JobTaskDTO;
import com.tianji.r.biz.source.model.DatabaseSourceDTO;
import com.tianji.r.biz.source.model.HdfsSourceDTO;
import com.tianji.r.biz.source.model.HiveSourceDTO;
import com.tianji.r.biz.source.model.ScpSourceDTO;
import com.tianji.r.biz.source.model.SshSourceDTO;
import com.tianji.r.biz.source.model.TransportSourceDTO;
import com.tianji.r.biz.struct.model.ConfGroupDTO;
import com.tianji.r.biz.struct.model.DbtableConfDTO;
import com.tianji.r.biz.struct.model.DbtableDTO;
import com.tianji.r.biz.struct.model.DbtableOutDTO;
import com.tianji.r.biz.struct.model.HdfsPathDTO;
import com.tianji.r.biz.struct.model.HiveTableDTO;
import com.tianji.r.biz.struct.model.MapRedAlgorithmDTO;
import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.Global;
import com.tianji.r.core.conf.MapRedAlgorithmConf;
import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.conf.model.DBTableOutFile;
import com.tianji.r.core.conf.model.HdfsPathNew;
import com.tianji.r.core.conf.model.HiveTableNew;
import com.tianji.r.core.conf.model.SCPTransportModel;
import com.tianji.r.core.job.task.DBTableExportTask;
import com.tianji.r.core.util.HdfsSource;
import com.tianji.r.core.util.HiveSource;
import com.tianji.r.core.util.ScpSource;
import com.tianji.r.core.util.SshSource;

@Service
public class MetadataFactory {

    @Autowired
    Global global;

    /**
     * Create BasicDataSource
     */
    public void createDataSource(DatabaseSourceDTO dataSourceDTO) {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(dataSourceDTO.getDriver());
        ds.setUrl(dataSourceDTO.getUrl());
        ds.setUsername(dataSourceDTO.getUsername());
        ds.setPassword(dataSourceDTO.getPassword());
        ds.setMaxActive(dataSourceDTO.getMaxActive());
        ds.setMaxIdle(dataSourceDTO.getMaxIdle());
        ds.setMaxWait(dataSourceDTO.getMaxWait());

        global.setDto(dataSourceDTO.getBeanName(), dataSourceDTO);
        global.setMeta(dataSourceDTO.getBeanName(), ds);
    }

    /**
     * Create SCP Source
     * 
     * TODO merge to one class
     */
    public void createScpSource(ScpSourceDTO scpSourceDTO) {
        ScpSource scp = new ScpSource();
        scp.setHost(scpSourceDTO.getHost());
        scp.setUsername(scpSourceDTO.getUsername());
        scp.setPassword(scpSourceDTO.getPassword());
        scp.setPort(scpSourceDTO.getPort());

        global.setDto(scpSourceDTO.getBeanName(), scpSourceDTO);
        global.setMeta(scpSourceDTO.getBeanName(), scp);
    }

    public void createSshSource(SshSourceDTO sshSourceDTO) {
        SshSource ssh = new SshSource();
        ssh.setHost(sshSourceDTO.getHost());
        ssh.setUsername(sshSourceDTO.getUsername());
        ssh.setPassword(sshSourceDTO.getPassword());
        ssh.setPort(sshSourceDTO.getPort());

        global.setDto(sshSourceDTO.getBeanName(), sshSourceDTO);
        global.setMeta(sshSourceDTO.getBeanName(), ssh);
    }

    public void createHdfsSource(HdfsSourceDTO hdfsSourceDTO) {
        HdfsSource hdfs = new HdfsSource();
        hdfs.setHdfsPath(hdfsSourceDTO.getHdfsPath());
        hdfs.setResourceFiles(split2List(hdfsSourceDTO.getResourceFiles(), ";"));
        hdfs.setSshSource(global.getMeta(hdfsSourceDTO.getSshSourceRef(), SshSource.class));

        global.setDto(hdfsSourceDTO.getBeanName(), hdfsSourceDTO);
        global.setMeta(hdfsSourceDTO.getBeanName(), hdfs);
    }

    @Autowired
    HiveTemplate rHiveTemplate;

    public void createHiveTemplate() {
        global.setMeta("rHiveTemplate", rHiveTemplate);
    }

    public void createHiveSource(HiveSourceDTO hiveSourceDTO) {
        HiveSource hive = new HiveSource();
        hive.setHiveTemplate(global.getMeta(hiveSourceDTO.getHiveTemplateRef(), HiveTemplate.class));
        hive.setHost(hiveSourceDTO.getHost());
        hive.setPort(hiveSourceDTO.getPort());
        hive.setSshSource(global.getMeta(hiveSourceDTO.getSshSourceRef(), SshSource.class));

        global.setDto(hiveSourceDTO.getBeanName(), hiveSourceDTO);
        global.setMeta(hiveSourceDTO.getBeanName(), hive);
    }

    /**
     * Create Transport Source
     */
    public void createTransportModel(TransportSourceDTO transportSource) {
        if (transportSource.getProtocol().equalsIgnoreCase("SCP")) {
            SCPTransportModel transport = new SCPTransportModel();

            transport.setLocalFolder(transportSource.getLocalFolder());
            transport.setProtocol(transportSource.getProtocol());
            transport.setConection(global.getMeta(transportSource.getConnectionRef(), ScpSource.class));
            // transport.setRemoteFile();//TODO useless??

            global.setDto(transportSource.getBeanName(), transportSource);
            global.setMeta(transportSource.getBeanName(), transport);
        }
    }

    /**
     * Create DBTable out file
     */
    public void createDBTableOutFile(DbtableOutDTO dbtableOutDTO) {
        DBTableOutFile outFile = new DBTableOutFile();
        outFile.setFileName(dbtableOutDTO.getFileName());
        outFile.setFolder(dbtableOutDTO.getFolder());
        outFile.setSql(dbtableOutDTO.getOutSql());
        outFile.setDataSource(global.getMeta(dbtableOutDTO.getDatabaseSourceRef(), BasicDataSource.class));
        outFile.setTransport(global.getMeta(dbtableOutDTO.getTransportRef(), SCPTransportModel.class));

        global.setDto(dbtableOutDTO.getBeanName(), dbtableOutDTO);
        global.setMeta(dbtableOutDTO.getBeanName(), outFile);
    }

    /**
     * Create DBTable out file
     */
    public void createDBTable(DbtableDTO dbtableDTO) {
        DBTableNew table = new DBTableNew();
        table.setTableName(dbtableDTO.getTableName());
        table.setLoadWay(dbtableDTO.getLoadWay());
        table.setCreateSQLs(split2List(dbtableDTO.getCreateSQLs(), ";"));
        table.setDropSQLs(split2List(dbtableDTO.getDropSQLs(), ";"));
        table.setDataSource(global.getMeta(dbtableDTO.getDatabaseSourceRef(), BasicDataSource.class));

        global.setDto(dbtableDTO.getBeanName(), dbtableDTO);
        global.setMeta(dbtableDTO.getBeanName(), table);

        // TODO PostgreSQL parameters
        // table.setFolder(folder);
        // table.setTransport(transport);
        // table.setLocalFile();

    }

    /**
     * Create DB Table Conf Object
     */
    public void createDBTableConf(DbtableConfDTO dbtableConfDTO) {
        DatabaseJobConf conf = new DatabaseJobConf();
        conf.setTaskName(dbtableConfDTO.getTaskName());
        conf.setDbTable(global.getMeta(dbtableConfDTO.getDbtableRef(), DBTableNew.class));
        conf.setOutFileTable(global.getMeta(dbtableConfDTO.getDbtableOutRef(), DBTableOutFile.class));

        global.setDto(dbtableConfDTO.getBeanName(), dbtableConfDTO);
        global.setMeta(dbtableConfDTO.getBeanName(), conf);
    }

    public void createConfGroup(List<ConfGroupDTO> list) {
        List<DatabaseJobConf> clist = new ArrayList<DatabaseJobConf>();
        String key = null;
        for (ConfGroupDTO dto : list) {
            DatabaseJobConf jconf = global.getMeta(dto.getConfRef(), DatabaseJobConf.class);
            if (jconf != null) {
                key = dto.getGroupName();
                clist.add(jconf);
            }
        }
        if (key != null && clist.size() > 0) {
            global.setMeta(key, clist);
        }
    }

    public void createHdfsPath(HdfsPathDTO hdfsPathDTO) {
        HdfsPathNew hp = new HdfsPathNew();
        hp.setDbTable(global.getMeta(hdfsPathDTO.getDbtableRef(), DBTableNew.class));
        hp.setHdfsSource(global.getMeta(hdfsPathDTO.getHdfsSourceRef(), HdfsSource.class));
        hp.setLoadWay(hdfsPathDTO.getLoadWay());
        hp.setPath(hdfsPathDTO.getPath());

        global.setDto(hdfsPathDTO.getBeanName(), hdfsPathDTO);
        global.setMeta(hdfsPathDTO.getBeanName(), hp);
    }

    public void createHiveTable(HiveTableDTO hiveTableDTO) {
        HiveTableNew table = new HiveTableNew();
        table.setFrom(hiveTableDTO.getOrigin());
        table.setLoadWay(hiveTableDTO.getLoadWay());
        table.setHiveSource(global.getMeta(hiveTableDTO.getHiveSourceRef(), HiveSource.class));

        if (hiveTableDTO.getTableName() != null) {
            table.setTableName(hiveTableDTO.getTableName());
        }
        if (hiveTableDTO.getCreateHQLs() != null) {
            table.setCreateHQLs(split2List(hiveTableDTO.getCreateHQLs(), ";"));
        }
        if (hiveTableDTO.getDropHQLs() != null) {
            table.setDropHQLs(split2List(hiveTableDTO.getDropHQLs(), ";"));
        }
        if (hiveTableDTO.getDbtableRef() != null) {
            table.setDbTable(global.getMeta(hiveTableDTO.getDbtableRef(), DBTableNew.class));
        }
        if (hiveTableDTO.getHdfsPathRef() != null) {
            table.setHdfsPath(global.getMeta(hiveTableDTO.getHdfsPathRef(), HdfsPathNew.class));
        }
        global.setDto(hiveTableDTO.getBeanName(), hiveTableDTO);
        global.setMeta(hiveTableDTO.getBeanName(), table);
    }

    public void createMapRedAlgorithm(MapRedAlgorithmDTO dto) {
        MapRedAlgorithmConf conf = new MapRedAlgorithmConf();
        conf.setTaskName(dto.getBeanName());
        conf.setHdfsPath(global.getMeta(dto.getHdfsPathRef(), HdfsPathNew.class));
        conf.setMapReduceClass(dto.getMapReduceClass());
        conf.setMapperClass(dto.getMapperClass());
        conf.setReducerClass(dto.getReducerClass());
        conf.setOutputKeyClass(dto.getOutputKeyClass());
        conf.setOutputValueClass(dto.getOutputValueClass());

        global.setDto(dto.getBeanName(), dto);
        global.setMeta(dto.getBeanName(), conf);
    }

    @Autowired
    DBTableExportTask DBTableExportTask;

    /**
     * TODO
     */
    @SuppressWarnings("unchecked")
    public void createJobTask(JobTaskDTO jobTaskDTO) {
        List<DatabaseJobConf> list = global.getMeta(jobTaskDTO.getConfGroupRef(), ArrayList.class);
        DBTableExportTask.setDbSyncConfList(list);
        global.setMeta(jobTaskDTO.getBeanName(), DBTableExportTask);
    }

    /**
     * TODO
     */
    public void createJobStep(JobStepDTO jobStepDTO) {
        Tasklet task = global.getMeta(jobStepDTO.getJobTaskRef(), Tasklet.class);
        TaskletStep step = new TaskletStep();
        step.setName(jobStepDTO.getBeanName());
        step.setTasklet(task);
        global.setMeta(jobStepDTO.getBeanName(), step);
    }

    //
    // public void createJobStepCompose(List<JobStepComposeDTO> list) {
    // List<TaskletStep> stepList = new ArrayList<TaskletStep>();
    // String key = null;
    // for (JobStepComposeDTO dto : list) {
    // key = dto.getJobRef();
    // stepList.add(global.getMeta(dto.getJobStepRef(), TaskletStep.class));
    // }
    // global.setMeta(jobStepComposeKey(key), stepList);
    // }

    // public void createJob(JobDTO dto) {
    // @SuppressWarnings("unchecked")
    // ArrayList<TaskletStep> list = global.getMeta(jobStepComposeKey(dto.getBeanName()), ArrayList.class);
    //
    // FlowJob job = new FlowJob();
    //
    // SimpleFlow flow = new SimpleFlow(dto.getBeanName());
    // job.setFlow(flow);
    //
    // job.setBeanName(dto.getBeanName());
    // job.setName(dto.getBeanName());
    // for (TaskletStep step : list) {
    // job.addStep(step);
    // }
    // global.setMeta(dto.getBeanName(), job);
    // }

    /*
     * tools
     */
    private List<String> split2List(String contnt, String sign) {
        String[] sqls = contnt.split(sign);
        List<String> sqllist = new ArrayList<String>();
        for (String s : sqls) {
            sqllist.add(s);
        }
        return sqllist;
    }

    // private String jobStepComposeKey(String name) {
    // return name + "_compose";
    // }
}
