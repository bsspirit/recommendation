package com.tianji.r.core.etl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tianji.r.core.storage.DatabaseService;

@Service
@Scope(value = "prototype")
public class TransformMySQLService{// implements ETLCommand {

    private static final Logger log = Logger.getLogger(TransformMySQLService.class);
    private List<String> sqllist = new ArrayList<String>();

    @Autowired
    DatabaseService databaseService;

    public void addSqlList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.sqllist.addAll(list);
        }
    }

    public void exec() throws SQLException {
        for (String sql : sqllist) {
            databaseService.execute(sql);
        }
        clearSqlList();
    }

//    @Override
//    public void setDataSource(DataSource dataSource) {
//        databaseService.setDataSource(dataSource);
//        clearSqlList();
//    }

    private void clearSqlList() {
        sqllist.clear();
    }

    public void setDataSource(BasicDataSource dataSource) throws SQLException {
        databaseService.setDataSource(dataSource);
        clearSqlList();
    }

}
