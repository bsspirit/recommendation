package com.tianji.r.core.storage;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype")
public class DatabaseService {

    private static final Logger log = Logger.getLogger(DatabaseService.class);

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Map<String, Object>> getList(String sql) {
        log.info(sql);
        return jdbcTemplate.queryForList(sql);
    }

    public Map<String, Object> getObject(String sql) {
        log.info(sql);
        return jdbcTemplate.queryForMap(sql);
    }

    public void insert(String sql) {
        log.info(sql);
        jdbcTemplate.execute(sql);
    }

    public void delete(String sql) {
        log.info(sql);
        jdbcTemplate.execute(sql);
    }

    public void execute(String sql) {
        log.info(sql);
        jdbcTemplate.execute(sql);
    }

}
