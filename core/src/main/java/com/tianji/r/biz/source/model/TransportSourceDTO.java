//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is TransportSource Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class TransportSourceDTO extends BaseSourceDTO  {

private static final long serialVersionUID = 13629688432031L;

public TransportSourceDTO(){}
public TransportSourceDTO(String beanName, String localFolder, String protocol, String connectionRef, Timestamp create_date){
this.beanName = beanName;
this.localFolder = localFolder;
this.protocol = protocol;
this.connectionRef = connectionRef;
this.create_date = create_date;
}


private int id;
private String beanName;
private String localFolder;
private String protocol;
private String connectionRef;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getLocalFolder (){
return this.localFolder;
}
public String getProtocol (){
return this.protocol;
}
public String getConnectionRef (){
return this.connectionRef;
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
public void setLocalFolder(String localFolder) {
this.localFolder = localFolder;
}
public void setProtocol(String protocol) {
this.protocol = protocol;
}
public void setConnectionRef(String connectionRef) {
this.connectionRef = connectionRef;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
