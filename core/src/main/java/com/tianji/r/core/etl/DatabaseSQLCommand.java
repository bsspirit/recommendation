package com.tianji.r.core.etl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.tianji.r.core.conf.model.DBTableNew;
import com.tianji.r.core.storage.DatabaseDAO;

@Service
@Scope(value = "prototype")
public class DatabaseSQLCommand {

    private static final Logger log = Logger.getLogger(DatabaseSQLCommand.class);
    private List<String> sqllist = new ArrayList<String>();

    @Autowired
    DatabaseDAO databaseDAO;

    public void addSqlList(List<String> list) {
        if (list != null && list.size() > 0) {
            this.sqllist.addAll(list);
        }
    }

    public void exec() throws SQLException {
        for (String sql : sqllist) {
            databaseDAO.execute(sql);
        }
        clearSqlList();
    }

    private void clearSqlList() {
        sqllist.clear();
    }

    public void setDataSource(BasicDataSource dataSource) throws SQLException {
        databaseDAO.setDataSource(dataSource);
        clearSqlList();
    }

    /**
     * wrapper function
     */
    public void execDBTable(DBTableNew table) throws SQLException {
        String way = table.getLoadWay();
        way = way == null ? "APPEND" : way.toUpperCase();
        log.info("ImportTableWay: " + way);
        
        if (way.equalsIgnoreCase("OVERRIDE")) {
            addSqlList(table.getDropSQLs());
            addSqlList(table.getCreateSQLs());
        } else if (way.equalsIgnoreCase("update")) {// TODO next version
        } else {// append
        }

        setDataSource(table.getDataSource());
        exec();
    }

}
