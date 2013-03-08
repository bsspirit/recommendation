//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is SshSource Model DTO
 * @author Conan Zhang
 * @date 2013-03-08
 */
public class SshSourceDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13627364520780L;

public SshSourceDTO(){}
public SshSourceDTO(String beanName, String host, String port, String username, String password, Timestamp create_date){
this.beanName = beanName;
this.host = host;
this.port = port;
this.username = username;
this.password = password;
this.create_date = create_date;
}


private int id;
private String beanName;
private String host;
private String port;
private String username;
private String password;
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
public String getPort (){
return this.port;
}
public String getUsername (){
return this.username;
}
public String getPassword (){
return this.password;
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
public void setPort(String port) {
this.port = port;
}
public void setUsername(String username) {
this.username = username;
}
public void setPassword(String password) {
this.password = password;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
