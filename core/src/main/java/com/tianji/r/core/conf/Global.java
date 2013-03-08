package com.tianji.r.core.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.tianji.r.biz.source.BaseSourceDTO;

@Service
public class Global {

    private Map<String, BaseSourceDTO> dto = new HashMap<String, BaseSourceDTO>();
    private Map<String, Object> meta = new HashMap<String, Object>();

    public void setMeta(String k, Object v) {
        meta.put(k, v);
    }

    public Object getMeta(String k) {
        return meta.get(k);
    }

    public void setDto(String k, BaseSourceDTO v) {
        dto.put(k, v);
    }

    public BaseSourceDTO getDto(String k) {
        return dto.get(k);
    }

}
