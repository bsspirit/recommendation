package com.tianji.r.core.conf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

abstract public class ApplicationMain {

    private static ApplicationContext ctx = null;

    protected ApplicationMain() {
    }

    protected static ApplicationContext getContext(String... configLocations) {
        if (ctx == null) {
            String[] configs = new String[configLocations.length + 1];
            configs[0] = "/r/qa/spring.xml";
            for (int i = 1; i < configs.length; i++) {
                configs[i] = configLocations[i - 1];
            }
            ctx = new ClassPathXmlApplicationContext(configs);
        }
        return ctx;
    }

    protected void exit() {
        System.exit(0);
    }

    abstract protected void runner();

}
