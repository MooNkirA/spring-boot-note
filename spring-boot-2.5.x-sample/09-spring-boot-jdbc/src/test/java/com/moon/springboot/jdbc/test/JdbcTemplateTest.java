package com.moon.springboot.jdbc.test;

import com.moon.springboot.jdbc.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * Spring Boot 整合 JdbcTemplate 测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-24 22:56
 * @description
 */
@SpringBootTest
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 测试保存数据
    @Test
    public void testJdbcTemplateSave() {
        String sql = "insert into tb_book values(4,'springboot','IT','这是一本好书')";
        jdbcTemplate.update(sql);
    }

    // 测试更新数据
    @Test
    public void testJdbcTemplateUpdate() {
        String sql = "update tb_book set name = ? where id = ?";
        Object[] args = {"修改后的书名", 2};
        int[] argTypes = {Types.VARCHAR, Types.INTEGER};
        jdbcTemplate.update(sql, args, argTypes);
    }

    // 测试删除数据
    @Test
    public void testJdbcTemplateDelete() {
        String sql = "delete from tb_book where id = ?";
        Object[] args = {3};
        int[] argTypes = {Types.INTEGER};
        jdbcTemplate.update(sql, args, argTypes);
    }

    // 测试查询数据
    @Test
    void testJdbcTemplateQuery() {
        String sql = "select * from tb_book";
        RowMapper<Book> rm = new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book temp = new Book();
                temp.setId(rs.getInt("id"));
                temp.setName(rs.getString("name"));
                temp.setType(rs.getString("type"));
                temp.setDescription(rs.getString("description"));
                return temp;
            }
        };
        List<Book> list = jdbcTemplate.query(sql, rm);
        System.out.println(list);
    }

}
