package com.tianji.r.core.job.addressBook;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AddressBookMain {

    @Autowired
    SimpleJobLauncher jobLauncher;
    
    private static ApplicationContext ctx = null;

    private AddressBookMain() {
    }

    public static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext("/r/qa/spring.xml");
        }
        return ctx;
    }

    public static void main(String[] args) throws Exception {
        AddressBookMain main = AddressBookMain.getContext().getBean("addressBookMain", AddressBookMain.class);
        main.runner();
    }

    public void runner() throws Exception {
        Job job = (Job)AddressBookMain.getContext().getBean("addressBookJob");
        JobParameters params = new JobParametersBuilder().addString("task", "AddressBook").toJobParameters();
        jobLauncher.run(job, params);
    }

}
