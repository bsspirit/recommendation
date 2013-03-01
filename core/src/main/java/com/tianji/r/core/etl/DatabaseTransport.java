package com.tianji.r.core.etl;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * DBCP DataSource POOL
 * 
 * @author Conan_Z
 * 
 */
@Deprecated
public interface DatabaseTransport {

    void setDataSource(BasicDataSource dataSource);

}
