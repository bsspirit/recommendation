package com.tianji.r.core.conf.model;

import com.tianji.r.core.util.SCPConnection;

public class SCPTransportModel extends TransportModel {

    private SCPConnection conection;

    public SCPConnection getConection() {
        return conection;
    }

    public void setConection(SCPConnection conection) {
        this.conection = conection;
    }

}
