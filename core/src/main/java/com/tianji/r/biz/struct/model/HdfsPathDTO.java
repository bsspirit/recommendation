//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is HdfsPath Model DTO
 * @author Conan Zhang
 * @date 2013-03-27
 */
public class HdfsPathDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13643760997032L;

public HdfsPathDTO(){}
public HdfsPathDTO(String beanName, String loadWay, String path, String dbtableRef, String hdfsSourceRef, Timestamp create_date){
this.beanName = beanName;
this.loadWay = loadWay;
this.path = path;
this.dbtableRef = dbtableRef;
this.hdfsSourceRef = hdfsSourceRef;
this.create_date = create_date;
}


private int id;
private String beanName;
private String loadWay;
private String path;
private String dbtableRef;
private String hdfsSourceRef;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getLoadWay (){
return this.loadWay;
}
public String getPath (){
return this.path;
}
public String getDbtableRef (){
return this.dbtableRef;
}
public String getHdfsSourceRef (){
return this.hdfsSourceRef;
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
public void setLoadWay(String loadWay) {
this.loadWay = loadWay;
}
public void setPath(String path) {
this.path = path;
}
public void setDbtableRef(String dbtableRef) {
this.dbtableRef = dbtableRef;
}
public void setHdfsSourceRef(String hdfsSourceRef) {
this.hdfsSourceRef = hdfsSourceRef;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
