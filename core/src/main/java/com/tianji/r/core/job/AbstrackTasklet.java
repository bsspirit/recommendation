package com.tianji.r.core.job;

import com.tianji.r.core.job.dbsync.DbSyncConf;

public abstract class AbstrackTasklet {

    protected DbSyncConf dbSyncConf;

    public void setDbSyncConf(DbSyncConf dbSyncConf) {
        this.dbSyncConf = dbSyncConf;
    }

}
