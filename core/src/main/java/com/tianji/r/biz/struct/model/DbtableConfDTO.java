//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is DbtableConf Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class DbtableConfDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13629948741712L;

public DbtableConfDTO(){}
public DbtableConfDTO(String beanName, String taskName, String dbtableRef, String dbtableOutRef, Timestamp create_date){
this.beanName = beanName;
this.taskName = taskName;
this.dbtableRef = dbtableRef;
this.dbtableOutRef = dbtableOutRef;
this.create_date = create_date;
}


private int id;
private String beanName;
private String taskName;
private String dbtableRef;
private String dbtableOutRef;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getTaskName (){
return this.taskName;
}
public String getDbtableRef (){
return this.dbtableRef;
}
public String getDbtableOutRef (){
return this.dbtableOutRef;
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
public void setTaskName(String taskName) {
this.taskName = taskName;
}
public void setDbtableRef(String dbtableRef) {
this.dbtableRef = dbtableRef;
}
public void setDbtableOutRef(String dbtableOutRef) {
this.dbtableOutRef = dbtableOutRef;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
