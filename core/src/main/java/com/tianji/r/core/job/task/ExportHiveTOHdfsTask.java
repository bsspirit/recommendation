package com.tianji.r.core.job.task;

import org.springframework.stereotype.Service;

@Service
public class ExportHiveTOHdfsTask {

    // 1
    // hadoop fs -cp source_path target_path

    // 2
    // INSERT OVERWRITE LOCAL DIRECTORY '/tmp/ca_employees'
    // SELECT name, salary, address
    // FROM employees
    // WHERE se.state = 'CA';

}
