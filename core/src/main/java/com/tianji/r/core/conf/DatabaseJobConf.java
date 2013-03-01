package com.tianji.r.core.conf;

import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.conf.model.DBTableOutFile;

/**
 * 
 * @author Conan_Z
 * 
 */
public class DatabaseJobConf extends JobConf {

    private DBTableOutFile outFileTable;// outfile table
    private DBTableNew dbTable;// import table

    public DBTableOutFile getOutFileTable() {
        return outFileTable;
    }

    public void setOutFileTable(DBTableOutFile outFileTable) {
        this.outFileTable = outFileTable;
    }

    public DBTableNew getDbTable() {
        return dbTable;
    }

    public void setDbTable(DBTableNew dbTable) {
        this.dbTable = dbTable;
    }

    public String getLocalFilePath() {
        return getOutFileTable().getTransport().getLocalFolder() + this.getOutFileTable().getFileName();
    }

    public String getRemoteFilePath() {
        return getOutFileTable().getFilePath();
    }

}
