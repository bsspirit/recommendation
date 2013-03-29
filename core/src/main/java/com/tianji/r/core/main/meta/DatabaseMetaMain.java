package com.tianji.r.core.main.meta;

import java.util.ArrayList;
import java.util.List;

import org.mortbay.log.Log;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.DatabaseJobConf;
import com.tianji.r.core.conf.Global;
import com.tianji.r.core.conf.meta.LoadMetaData;
import com.tianji.r.core.job.task.DBTableExportTask;
import com.tianji.r.core.job.task.DBTableImportTask;
import com.tianji.r.core.job.task.FileDownloadTask;
import com.tianji.r.core.main.ApplicationMain;
import com.tianji.r.core.storage.DatabaseDAO;

@Service
public class DatabaseMetaMain extends ApplicationMain {

    public static void main(String[] args) {
        args = new String[1];
        args[0] = "/r/biz/spring-biz.xml";

        ApplicationContext ctx = getContext(args);
        DatabaseMetaMain main = ctx.getBean(DatabaseMetaMain.class);

        main.runner();
        // main.showBeans();
        main.exit();
    }

    @Autowired
    DatabaseDAO databaseDAO;
    @Autowired
    Global global;
    @Autowired
    LoadMetaData loadMetaData;

    @Autowired
    SimpleJobLauncher jobLauncher;

    @Override
    protected void runner() {
        Log.info("RUNNER: MetaDataMAIN");
        loadMetaData.createScpSource();
        loadMetaData.createDataSource();
        loadMetaData.createTransport();
        loadMetaData.createDBTableOut();
        loadMetaData.createDBTable();
        loadMetaData.createDBTableConf();
        loadMetaData.createConfGroup("dbSyncConfList");

        // loadMetaData.createJobTask("pymk_dbsync_DBTableExportTask");
        // loadMetaData.createJobStep("pymk_dbsync_DBTableExportStep");
        // createJobStepCompose("pymk_dbSyncJob_1");
        // createJob("pymk_dbSyncJob_1");
        // SimpleJob job = global.getMeta("pymk_dbSyncJob_1", SimpleJob.class);
        // System.out.println(job);
        
        try {
            @SuppressWarnings("unchecked")
            List<DatabaseJobConf> list = global.getMeta("dbSyncConfList", ArrayList.class);
            ApplicationContext ctx = getContext();
            
            DBTableExportTask dBTableExportTask = ctx.getBean("DBTableExportTask", DBTableExportTask.class);
            dBTableExportTask.setDbSyncConfList(list);

            FileDownloadTask fileDownloadTask = ctx.getBean("fileDownloadTask", FileDownloadTask.class);
            fileDownloadTask.setDbSyncConfList(list);

            DBTableImportTask dBTableImportTask = ctx.getBean("DBTableImportTask", DBTableImportTask.class);
            dBTableImportTask.setDbSyncConfList(list);
            
            Job job = (Job) DatabaseMetaMain.getContext().getBean("pymk_dbSyncJob");
            JobParameters params = new JobParametersBuilder().addString("task", job.getName()).toJobParameters();
            jobLauncher.run(job, params);
            
            // FlowJob job = new FlowJob();
            // job.setBeanName("pymk_dbSyncJob");
            // job.setName("pymk_dbSyncJob");
            // job.setJobRepository(jobRepository);
            //
            // // SimpleStepFactoryBean ssBean = new SimpleStepFactoryBean();
            // // TaskletStep step = (TaskletStep) ssBean.getObject();
            //
            //
            // List<StateTransition> stateTransitions = new ArrayList<StateTransition>();
            //
            // TaskletStep step = global.getMeta("pymk_dbsync_DBTableExportStep", TaskletStep.class);
            // step.setJobRepository(jobRepository);
            // State state = new StepState(step);
            //
            // StateTransition st = StateTransition.createEndStateTransition(state);
            // stateTransitions.add(st);
            //
            // SimpleFlowFactoryBean sfbean = new SimpleFlowFactoryBean();
            // sfbean.setName("pymk_dbSyncJob");
            // sfbean.setStateTransitions(stateTransitions);
            // SimpleFlow flow = (SimpleFlow) sfbean.getObject();
            //
            // job.setFlow(flow);
            // job.afterPropertiesSet();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Create SpringBean from Database
// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
// context.registerBeanDefinition(beanName, beanDefinition);

// AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
// ctx.setParent(getContext());
// ctx.refresh();
//
// BeanDefinition bean = new RootBeanDefinition(BasicDataSource.class);
// bean.setScope(BeanDefinition.SCOPE_PROTOTYPE);
// ctx.getBeanFactory().registerSingleton("a1", bean);

// DefaultListableBeanFactory parentBeanFactory = new DefaultListableBeanFactory();
// parentBeanFactory.registerSingleton("a1", a1);
// GenericApplicationContext parentContext = new GenericApplicationContext(parentBeanFactory);
// parentContext.refresh();
//
// getContext(new String[0], parentContext);
