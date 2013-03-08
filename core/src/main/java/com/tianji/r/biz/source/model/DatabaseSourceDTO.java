//Create by Conan, 2010 - 2012. E-mail:bsspirit@gmail.com
package com.tianji.r.biz.source.model;

import java.sql.Timestamp;

import com.tianji.r.biz.source.BaseSourceDTO;

/**
 * This is DatabaseSource Model DTO
 * @author Conan Zhang
 * @date 2013-03-08
 */
public class DatabaseSourceDTO extends BaseSourceDTO {

private static final long serialVersionUID = 13627311512500L;

public DatabaseSourceDTO(){}
public DatabaseSourceDTO(String driver, String url, String username, String password, Integer maxActive, Integer maxIdle, Long maxWait, Timestamp create_date){
this.driver = driver;
this.url = url;
this.username = username;
this.password = password;
this.maxActive = maxActive;
this.maxIdle = maxIdle;
this.maxWait = maxWait;
this.create_date = create_date;
}


private int id;
private String driver;
private String url;
private String username;
private String password;
private Integer maxActive;
private Integer maxIdle;
private Long maxWait;
private Timestamp create_date;

public int getId() {
return this.id;
}

public String getDriver (){
return this.driver;
}
public String getUrl (){
return this.url;
}
public String getUsername (){
return this.username;
}
public String getPassword (){
return this.password;
}
public Integer getMaxActive (){
return this.maxActive;
}
public Integer getMaxIdle (){
return this.maxIdle;
}
public Long getMaxWait (){
return this.maxWait;
}
public Timestamp getCreate_date (){
return this.create_date;
}


public void setId(int id) {
this.id = id;
}

public void setDriver(String driver) {
this.driver = driver;
}
public void setUrl(String url) {
this.url = url;
}
public void setUsername(String username) {
this.username = username;
}
public void setPassword(String password) {
this.password = password;
}
public void setMaxActive(Integer maxActive) {
this.maxActive = maxActive;
}
public void setMaxIdle(Integer maxIdle) {
this.maxIdle = maxIdle;
}
public void setMaxWait(Long maxWait) {
this.maxWait = maxWait;
}
public void setCreate_date(Timestamp create_date) {
this.create_date = create_date;
}

public static enum DatabaseType {
    MYSQL, POSTGRESQL, ORACLE, DB2, SQLSERVER, SYBASE
}

/**
 * TODO list database driver
 */
public String getDriverByType(DatabaseType type) {
    String driverClass = null;
    switch (type) {
    case MYSQL:
        driverClass = "com.mysql.jdbc.Driver";
        break;
    case POSTGRESQL:
        driverClass = "org.postgresql.Driver";
        break;
    case ORACLE:
        break;
    case DB2:
        break;
    case SQLSERVER:
        break;
    case SYBASE:
        break;
    default:// nothing
        break;
    }
    return driverClass;
}

}
