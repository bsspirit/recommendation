package com.tianji.r.core.conf.model;

import com.tianji.r.core.util.ScpSource;

public class SCPTransportModel extends TransportModel {

    private ScpSource conection;

    public ScpSource getConection() {
        return conection;
    }

    public void setConection(ScpSource conection) {
        this.conection = conection;
    }

}
