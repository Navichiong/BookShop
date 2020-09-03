package com.nvc.bookshop.handler;

import com.nvc.bookshop.pojo.enums.Category;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryTypeHandler implements TypeHandler<Category> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Category category, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, category.getCode());
    }

    @Override
    public Category getResult(ResultSet rs, String s) throws SQLException {
        return Category.getCategoryDescByCode(rs.getInt(s));
    }

    @Override
    public Category getResult(ResultSet rs, int i) throws SQLException {
        return Category.getCategoryDescByCode(rs.getInt(i));
    }

    @Override
    public Category getResult(CallableStatement cs, int i) throws SQLException {
        return Category.getCategoryDescByCode(cs.getInt(i));
    }
}
