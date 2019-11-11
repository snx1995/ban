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
        return AuthorityLevel.getAuthorityLevel(rs.getInt(columnName));
    }

    @Override
    public AuthorityLevel getResult(ResultSet rs, int columnIndex) throws SQLException {
        return AuthorityLevel.getAuthorityLevel(rs.getInt(columnIndex));
    }

    @Override
    public AuthorityLevel getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return AuthorityLevel.getAuthorityLevel(cs.getInt(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, AuthorityLevel authorityLevel, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, authorityLevel.getLv());
    }

    @Override
    public AuthorityLevel getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return AuthorityLevel.getAuthorityLevel(resultSet.getInt(s));
    }

    @Override
    public AuthorityLevel getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return AuthorityLevel.getAuthorityLevel(resultSet.getInt(i));
    }

    @Override
    public AuthorityLevel getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return AuthorityLevel.getAuthorityLevel(callableStatement.getInt(i));
    }
}
