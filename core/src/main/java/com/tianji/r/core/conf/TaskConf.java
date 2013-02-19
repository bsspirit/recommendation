package com.tianji.r.core.conf;


public interface TaskConf<E extends JobConf> {

    void setJobConf(E jobConf);

}
