//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;
import org.conan.base.BaseObject;

/**
 * This is ConfGroup Model DTO
 * @author Conan Zhang
 * @date 2013-03-11
 */
public class ConfGroupDTO extends BaseObject {

private static final long serialVersionUID = 13629948741711L;

public ConfGroupDTO(){}
public ConfGroupDTO(String groupName, String confRef, String confType, Timestamp create_date){
this.groupName = groupName;
this.confRef = confRef;
this.confType = confType;
this.create_date = create_date;
}


private int id;
private String groupName;
private String confRef;
private String confType;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getGroupName (){
return this.groupName;
}
public String getConfRef (){
return this.confRef;
}
public String getConfType (){
return this.confType;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setGroupName(String groupName) {
this.groupName = groupName;
}
public void setConfRef(String confRef) {
this.confRef = confRef;
}
public void setConfType(String confType) {
this.confType = confType;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
