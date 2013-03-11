//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is JobStepCompose Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class JobStepComposeDTO extends BaseObject {

private static final long serialVersionUID = 13629948741711L;

public JobStepComposeDTO(){}
public JobStepComposeDTO(String jobStepRef, String jobNextStepRef, String jobRef, Integer stepType, Timestamp create_date){
this.jobStepRef = jobStepRef;
this.jobNextStepRef = jobNextStepRef;
this.jobRef = jobRef;
this.stepType = stepType;
this.create_date = create_date;
}


private int id;
private String jobStepRef;
private String jobNextStepRef;
private String jobRef;
private Integer stepType;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getJobStepRef (){
return this.jobStepRef;
}
public String getJobNextStepRef (){
return this.jobNextStepRef;
}
public String getJobRef (){
return this.jobRef;
}
public Integer getStepType (){
return this.stepType;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setJobStepRef(String jobStepRef) {
this.jobStepRef = jobStepRef;
}
public void setJobNextStepRef(String jobNextStepRef) {
this.jobNextStepRef = jobNextStepRef;
}
public void setJobRef(String jobRef) {
this.jobRef = jobRef;
}
public void setStepType(Integer stepType) {
this.stepType = stepType;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
