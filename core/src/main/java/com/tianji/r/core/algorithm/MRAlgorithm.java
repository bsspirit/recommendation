package com.tianji.r.core.algorithm;

import org.springframework.data.hadoop.hive.HiveTemplate;

public interface MRAlgorithm {

    void setHiveTemplate(HiveTemplate hiveTemplate);

}
