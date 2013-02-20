package com.tianji.r.core.conf;

import java.util.List;

public class DatabaseJobConfList extends JobConf{

    private List<DatabaseJobConf> dbSyncConfList;

    public List<DatabaseJobConf> getDbSyncConfList() {
        return dbSyncConfList;
    }

    public void setDbSyncConfList(List<DatabaseJobConf> dbSyncConfList) {
        this.dbSyncConfList = dbSyncConfList;
    }
}
