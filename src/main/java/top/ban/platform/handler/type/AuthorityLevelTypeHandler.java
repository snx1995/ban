package top.ban.platform.handler.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import top.ban.common.AuthorityLevel;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(AuthorityLevel.class)
public class AuthorityLevelTypeHandler extends BaseTypeHandler<AuthorityLevel> {

    @Override
    public void setParameter(PreparedStatement ps, int i, AuthorityLevel parameter, JdbcType jdbcType) throws SQLException {
        super.setParameter(ps, i, parameter, jdbcType);
    }

    @Override
    public AuthorityLevel getResult(ResultSet rs, String columnName) throws SQLException {
        return super.getResult(rs, columnName);
    }

    @Override
    public AuthorityLevel getResult(ResultSet rs, int columnIndex) throws SQLException {
        return super.getResult(rs, columnIndex);
    }

    @Override
    public AuthorityLevel getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return super.getResult(cs, columnIndex);
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, AuthorityLevel authorityLevel, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, authorityLevel.toString());
    }

    @Override
    public AuthorityLevel getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public AuthorityLevel getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public AuthorityLevel getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
