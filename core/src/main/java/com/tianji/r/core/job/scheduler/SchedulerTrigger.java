package com.tianji.r.core.job.scheduler;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;

//@Service
public class SchedulerTrigger implements Trigger {

    private static final Logger log = Logger.getLogger(SchedulerTrigger.class);

    @Override
    public Date nextExecutionTime(TriggerContext triggerContext) {
        log.info("lastCompletionTime ==>" + triggerContext.lastCompletionTime());
        int diff = 5 * 1000;
        Date date = new Date(triggerContext.lastCompletionTime().getTime() + diff);
        log.info("nextExecutionTime ==>" + date);
        return date;
    }
}
