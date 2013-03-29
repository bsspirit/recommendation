//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is HiveSource Model DTO
 * @author Conan Zhang
 * @date 2013-03-28
 */
public class HiveSourceDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13644424595151L;

public HiveSourceDTO(){}
public HiveSourceDTO(String beanName, String host, Integer port, String sshSourceRef, String hiveTemplateRef, Timestamp create_date){
this.beanName = beanName;
this.host = host;
this.port = port;
this.sshSourceRef = sshSourceRef;
this.hiveTemplateRef = hiveTemplateRef;
this.create_date = create_date;
}


private int id;
private String beanName;
private String host;
private Integer port;
private String sshSourceRef;
private String hiveTemplateRef;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getHost (){
return this.host;
}
public Integer getPort (){
return this.port;
}
public String getSshSourceRef (){
return this.sshSourceRef;
}
public String getHiveTemplateRef (){
return this.hiveTemplateRef;
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
public void setHost(String host) {
this.host = host;
}
public void setPort(Integer port) {
this.port = port;
}
public void setSshSourceRef(String sshSourceRef) {
this.sshSourceRef = sshSourceRef;
}
public void setHiveTemplateRef(String hiveTemplateRef) {
this.hiveTemplateRef = hiveTemplateRef;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
