//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.struct.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is MapRedAlgorithm Model DTO
 * @author Conan Zhang
 * @date 2013-03-27
 */
public class MapRedAlgorithmDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13643760997181L;

public MapRedAlgorithmDTO(){}
public MapRedAlgorithmDTO(String beanName, String hdfsPathRef, String mapReduceClass, String mapperClass, String reducerClass, String outputKeyClass, String outputValueClass, Timestamp create_date){
this.beanName = beanName;
this.hdfsPathRef = hdfsPathRef;
this.mapReduceClass = mapReduceClass;
this.mapperClass = mapperClass;
this.reducerClass = reducerClass;
this.outputKeyClass = outputKeyClass;
this.outputValueClass = outputValueClass;
this.create_date = create_date;
}


private int id;
private String beanName;
private String hdfsPathRef;
private String mapReduceClass;
private String mapperClass;
private String reducerClass;
private String outputKeyClass;
private String outputValueClass;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getBeanName (){
return this.beanName;
}
public String getHdfsPathRef (){
return this.hdfsPathRef;
}
public String getMapReduceClass (){
return this.mapReduceClass;
}
public String getMapperClass (){
return this.mapperClass;
}
public String getReducerClass (){
return this.reducerClass;
}
public String getOutputKeyClass (){
return this.outputKeyClass;
}
public String getOutputValueClass (){
return this.outputValueClass;
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
public void setHdfsPathRef(String hdfsPathRef) {
this.hdfsPathRef = hdfsPathRef;
}
public void setMapReduceClass(String mapReduceClass) {
this.mapReduceClass = mapReduceClass;
}
public void setMapperClass(String mapperClass) {
this.mapperClass = mapperClass;
}
public void setReducerClass(String reducerClass) {
this.reducerClass = reducerClass;
}
public void setOutputKeyClass(String outputKeyClass) {
this.outputKeyClass = outputKeyClass;
}
public void setOutputValueClass(String outputValueClass) {
this.outputValueClass = outputValueClass;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}


}
