//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is JobStep Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class JobStepDTO extends BaseObject {

private static final long serialVersionUID = 13629948741711L;

public JobStepDTO(){}
public JobStepDTO(String beanName, String jobTaskRef, Timestamp create_date){
this.beanName = beanName;
this.jobTaskRef = jobTaskRef;
this.create_date = create_date;
}


private int id;
private String beanName;
private String jobTaskRef;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getJobTaskRef (){
return this.jobTaskRef;
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
public void setJobTaskRef(String jobTaskRef) {
this.jobTaskRef = jobTaskRef;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
