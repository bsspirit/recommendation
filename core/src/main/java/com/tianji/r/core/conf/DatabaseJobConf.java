package com.tianji.r.core.conf;

import com.tianji.r.core.conf.model.NewDBTable;
import com.tianji.r.core.conf.model.OutFileDBTable;
import com.tianji.r.core.conf.model.SCPTransportModel;

/**
 * 
 * @author Conan_Z
 * 
 */
public class DatabaseJobConf extends JobConf {

    private SCPTransportModel transport;
    private OutFileDBTable outFileTable;// outfile table
    private NewDBTable dbTable;// export table

    public OutFileDBTable getOutFileTable() {
        return outFileTable;
    }

    public SCPTransportModel getTransport() {
        return transport;
    }

    public void setTransport(SCPTransportModel transport) {
        this.transport = transport;
    }

    public void setOutFileTable(OutFileDBTable outFileTable) {
        this.outFileTable = outFileTable;
    }

    public NewDBTable getDbTable() {
        return dbTable;
    }

    public void setDbTable(NewDBTable dbTable) {
        this.dbTable = dbTable;
    }

    public String getLocalFilePath() {
        return getTransport().getLocalFolder() + this.getOutFileTable().getFileName();
    }

    public String getRemoteFilePath() {
        return getOutFileTable().getFilePath();
    }

}
