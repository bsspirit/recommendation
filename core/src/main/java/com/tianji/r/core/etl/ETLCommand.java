package com.tianji.r.core.etl;

import java.sql.SQLException;

import javax.sql.DataSource;

public interface ETLCommand {

    public void exec()throws SQLException;
    public void setDataSource(DataSource dataSource);

}
