package com.tianji.r.biz.source;

import org.conan.base.BaseObject;

/**
 * 
 * @author Conan_Z
 * 
 */
abstract public class BaseSourceDTO extends BaseObject{

    private static final long serialVersionUID = 6164846374567813346L;
    
    private String beanName;

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}
