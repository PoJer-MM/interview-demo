package com.pojer.dao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String query() {
        return jdbcTemplate.queryForObject("select name from t_user limit 1", String.class);
    }

    public int insert(String name) {
        return jdbcTemplate.update("insert into t_user(name) values (?)", name);
    }
}
