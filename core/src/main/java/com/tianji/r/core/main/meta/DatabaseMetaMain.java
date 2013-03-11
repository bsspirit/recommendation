package com.tianji.r.core.main.meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.tianji.r.biz.job.model.JobDTO;
import com.tianji.r.biz.job.model.JobStepComposeDTO;
import com.tianji.r.biz.job.service.JobService;
import com.tianji.r.biz.job.service.JobStepComposeService;
import com.tianji.r.biz.source.service.DatabaseSourceService;
import com.tianji.r.core.conf.Global;
import com.tianji.r.core.conf.meta.MetadataFactory;
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
    MetadataFactory metadataFactory;
    @Autowired
    DatabaseDAO databaseDAO;
    @Autowired
    Global global;
    @Autowired
    DatabaseSourceService databaseSourceService;

    @Autowired
    JobService jobService;
    @Autowired
    JobStepComposeService jobStepCompose;

    @Override
    protected void runner() {
        Log.info("RUNNER: MetaDataMAIN");

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("beanName", "pymk_dbSyncJob");
        JobDTO jobDTO = jobService.getJobOne(paramMap);
        System.out.println(jobDTO);

        paramMap.clear();
        paramMap.put("jobRef", jobDTO.getBeanName());
        List<JobStepComposeDTO> JobStepComposeDTOList = jobStepCompose.getJobStepComposes(paramMap);
        System.out.println(JobStepComposeDTOList);
        
        try {
            String firstName = jobStepCompose.getFirstJobStepName(paramMap);
            System.out.println(firstName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        


        // DatabaseSourceDTO dto = databaseSourceService.getDatabaseSourceById(1);
        // System.out.println(dto);
        // metadataFactory.createDataSource(dto);
        // databaseDAO.setDataSource((DataSource) global.getMeta("rDataSource"));
        // List<Map<String, Object>> list = databaseDAO.getList("select * from o_accounts limit 10");
        // for (Map<String, Object> map : list) {
        // System.out.println(map);
        // }
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
