//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is HdfsSource Model DTO
 * @author Conan Zhang
 * @date 2013-03-08
 */
public class HdfsSourceDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13627386185001L;

public HdfsSourceDTO(){}
public HdfsSourceDTO(String beanName, String hdfsPath, String sshSourceRef, String resourceFiles, Timestamp create_date){
this.beanName = beanName;
this.hdfsPath = hdfsPath;
this.sshSourceRef = sshSourceRef;
this.resourceFiles = resourceFiles;
this.create_date = create_date;
}


private int id;
private String beanName;
private String hdfsPath;
private String sshSourceRef;
private String resourceFiles;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getHdfsPath (){
return this.hdfsPath;
}
public String getSshSourceRef (){
return this.sshSourceRef;
}
public String getResourceFiles (){
return this.resourceFiles;
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
public void setHdfsPath(String hdfsPath) {
this.hdfsPath = hdfsPath;
}
public void setSshSourceRef(String sshSourceRef) {
this.sshSourceRef = sshSourceRef;
}
public void setResourceFiles(String resourceFiles) {
this.resourceFiles = resourceFiles;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
