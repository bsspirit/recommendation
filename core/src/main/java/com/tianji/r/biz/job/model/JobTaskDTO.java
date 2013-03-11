//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is JobTask Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class JobTaskDTO extends BaseObject {

private static final long serialVersionUID = 13629948741712L;

public JobTaskDTO(){}
public JobTaskDTO(String beanName, String confGroupRef, Timestamp create_date){
this.beanName = beanName;
this.confGroupRef = confGroupRef;
this.create_date = create_date;
}


private int id;
private String beanName;
private String confGroupRef;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getConfGroupRef (){
return this.confGroupRef;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setBeanName(String beanName) {
this.beanName = beanName;
}
public void setConfGroupRef(String confGroupRef) {
this.confGroupRef = confGroupRef;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
