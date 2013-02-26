package com.tianji.r.core.conf;

import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.conf.model.DBTableOutFile;
import com.tianji.r.core.conf.model.SCPTransportModel;

/**
 * 
 * @author Conan_Z
 * 
 */
public class DatabaseJobConf extends JobConf {

    private SCPTransportModel transport;
    private DBTableOutFile outFileTable;// outfile table
    private DBTableNew dbTable;// import table

    public DBTableOutFile getOutFileTable() {
        return outFileTable;
    }

    public SCPTransportModel getTransport() {
        return transport;
    }

    public void setTransport(SCPTransportModel transport) {
        this.transport = transport;
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
        return getTransport().getLocalFolder() + this.getOutFileTable().getFileName();
    }

    public String getRemoteFilePath() {
        return getOutFileTable().getFilePath();
    }

}
