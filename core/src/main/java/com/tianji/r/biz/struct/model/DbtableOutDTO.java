//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is DbtableOut Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class DbtableOutDTO extends BaseObject {

private static final long serialVersionUID = 13629948741562L;

public DbtableOutDTO(){}
public DbtableOutDTO(String beanName, String databaseSourceRef, String transportRef, String fileName, String folder, String outSql, Timestamp create_date){
this.beanName = beanName;
this.databaseSourceRef = databaseSourceRef;
this.transportRef = transportRef;
this.fileName = fileName;
this.folder = folder;
this.outSql = outSql;
this.create_date = create_date;
}


private int id;
private String beanName;
private String databaseSourceRef;
private String transportRef;
private String fileName;
private String folder;
private String outSql;
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
public String getTransportRef (){
return this.transportRef;
}
public String getFileName (){
return this.fileName;
}
public String getFolder (){
return this.folder;
}
public String getOutSql (){
return this.outSql;
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
public void setTransportRef(String transportRef) {
this.transportRef = transportRef;
}
public void setFileName(String fileName) {
this.fileName = fileName;
}
public void setFolder(String folder) {
this.folder = folder;
}
public void setOutSql(String outSql) {
this.outSql = outSql;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
