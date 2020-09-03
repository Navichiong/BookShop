package com.nvc.bookshop.handler;

import com.nvc.bookshop.pojo.enums.Suit;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SuitTypeHandler implements TypeHandler<Suit> {
    @Override
    public void setParameter(PreparedStatement ps, int i, Suit suit, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, suit.getCode());
    }

    @Override
    public Suit getResult(ResultSet rs, String s) throws SQLException {
        return Suit.getSuitDescByCode(rs.getInt(s));
    }

    @Override
    public Suit getResult(ResultSet rs, int i) throws SQLException {
        return Suit.getSuitDescByCode(rs.getInt(i));
    }

    @Override
    public Suit getResult(CallableStatement cs, int i) throws SQLException {
        return Suit.getSuitDescByCode(cs.getInt(i));
    }
}
