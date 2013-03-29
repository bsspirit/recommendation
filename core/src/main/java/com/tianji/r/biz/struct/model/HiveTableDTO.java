//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is HiveTable Model DTO
 * @author Conan Zhang
 * @date 2013-03-27
 */
public class HiveTableDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13643760997030L;

public HiveTableDTO(){}
public HiveTableDTO(String beanName, String tableName, String dbtableRef, String loadWay, String origin, String hdfsPathRef, String hiveSourceRef, String createHQLs, String dropHQLs, Timestamp create_date){
this.beanName = beanName;
this.tableName = tableName;
this.dbtableRef = dbtableRef;
this.loadWay = loadWay;
this.origin = origin;
this.hdfsPathRef = hdfsPathRef;
this.hiveSourceRef = hiveSourceRef;
this.createHQLs = createHQLs;
this.dropHQLs = dropHQLs;
this.create_date = create_date;
}


private int id;
private String beanName;
private String tableName;
private String dbtableRef;
private String loadWay;
private String origin;
private String hdfsPathRef;
private String hiveSourceRef;
private String createHQLs;
private String dropHQLs;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getTableName (){
return this.tableName;
}
public String getDbtableRef (){
return this.dbtableRef;
}
public String getLoadWay (){
return this.loadWay;
}
public String getOrigin (){
return this.origin;
}
public String getHdfsPathRef (){
return this.hdfsPathRef;
}
public String getHiveSourceRef (){
return this.hiveSourceRef;
}
public String getCreateHQLs (){
return this.createHQLs;
}
public String getDropHQLs (){
return this.dropHQLs;
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
public void setTableName(String tableName) {
this.tableName = tableName;
}
public void setDbtableRef(String dbtableRef) {
this.dbtableRef = dbtableRef;
}
public void setLoadWay(String loadWay) {
this.loadWay = loadWay;
}
public void setOrigin(String origin) {
this.origin = origin;
}
public void setHdfsPathRef(String hdfsPathRef) {
this.hdfsPathRef = hdfsPathRef;
}
public void setHiveSourceRef(String hiveSourceRef) {
this.hiveSourceRef = hiveSourceRef;
}
public void setCreateHQLs(String createHQLs) {
this.createHQLs = createHQLs;
}
public void setDropHQLs(String dropHQLs) {
this.dropHQLs = dropHQLs;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
