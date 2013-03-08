package com.tianji.r.core.main;

import org.springframework.batch.core.Job;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

abstract public class ApplicationMain {

    private static ApplicationContext ctx = null;
     final private static String baseConfig = "/r/qa/spring.xml"; //pymk
//    final private static String baseConfig = "/r/meta/spring.xml"; // meta

    protected ApplicationMain() {
    }

    protected static ApplicationContext getContext(String... configLocations) {
        if (ctx == null) {
            String[] configs = new String[configLocations.length + 1];
            configs[0] = baseConfig;
            for (int i = 1; i < configs.length; i++) {
                configs[i] = configLocations[i - 1];
            }
            ctx = new ClassPathXmlApplicationContext(configs);
        }
        return ctx;
    }

    public Job getJobBean(String jobName) {
        return getContext().getBean(jobName, Job.class);
    }

    protected void exit() {
        System.exit(0);
    }

    abstract protected void runner();

    /**
     * show tools
     */
    protected void showBeans() {
        System.out.println("=========Show Spring Application Beans=============");
        for (String n : ctx.getBeanDefinitionNames()) {
            System.out.println(n);
        }
        System.out.println("====================================================");
    }

}
