package com.tianji.r.core.main.meta;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.tianji.r.biz.source.model.DatabaseSourceDTO;
import com.tianji.r.biz.source.service.DatabaseSourceService;
import com.tianji.r.core.conf.Global;
import com.tianji.r.core.conf.meta.MetadataFactory;
import com.tianji.r.core.main.ApplicationMain;
import com.tianji.r.core.storage.DatabaseDAO;

//@Service
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

    @Override
    protected void runner() {
        Log.info("RUNNER: MetaDataMAIN");
        DatabaseSourceDTO dto = databaseSourceService.getDatabaseSourceById(1);
        System.out.println(dto);
        metadataFactory.createDataSource(dto);
        databaseDAO.setDataSource((DataSource) global.getMeta("rDataSource"));
        List<Map<String, Object>> list = databaseDAO.getList("select * from o_accounts limit 10");
        for (Map<String, Object> map : list) {
            System.out.println(map);
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
