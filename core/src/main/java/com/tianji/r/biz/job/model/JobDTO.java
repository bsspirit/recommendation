//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.job.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is Job Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class JobDTO extends BaseObject {

private static final long serialVersionUID = 13629948741711L;

public JobDTO(){}
public JobDTO(String beanName, String description, Timestamp create_date){
this.beanName = beanName;
this.description = description;
this.create_date = create_date;
}


private int id;
private String beanName;
private String description;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getDescription (){
return this.description;
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
public void setDescription(String description) {
this.description = description;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
