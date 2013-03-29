//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is Dbtable Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class DbtableDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13629948741561L;

public DbtableDTO(){}
public DbtableDTO(String beanName, String databaseSourceRef, String tableName, String loadWay, String createSQLs, String dropSQLs, Timestamp create_date){
this.beanName = beanName;
this.databaseSourceRef = databaseSourceRef;
this.tableName = tableName;
this.loadWay = loadWay;
this.createSQLs = createSQLs;
this.dropSQLs = dropSQLs;
this.create_date = create_date;
}


private int id;
private String beanName;
private String databaseSourceRef;
private String tableName;
private String loadWay;
private String createSQLs;
private String dropSQLs;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getDatabaseSourceRef (){
return this.databaseSourceRef;
}
public String getTableName (){
return this.tableName;
}
public String getLoadWay (){
return this.loadWay;
}
public String getCreateSQLs (){
return this.createSQLs;
}
public String getDropSQLs (){
return this.dropSQLs;
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
public void setDatabaseSourceRef(String databaseSourceRef) {
this.databaseSourceRef = databaseSourceRef;
}
public void setTableName(String tableName) {
this.tableName = tableName;
}
public void setLoadWay(String loadWay) {
this.loadWay = loadWay;
}
public void setCreateSQLs(String createSQLs) {
this.createSQLs = createSQLs;
}
public void setDropSQLs(String dropSQLs) {
this.dropSQLs = dropSQLs;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
