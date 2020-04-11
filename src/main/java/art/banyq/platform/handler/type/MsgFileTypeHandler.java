package art.banyq.platform.handler.type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import art.banyq.common.entity.message.file.MsgFileType;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(MsgFileType.class)
public class MsgFileTypeHandler extends BaseTypeHandler<MsgFileType> {

    @Override
    public MsgFileType getResult(ResultSet rs, String columnName) throws SQLException {
        return MsgFileType.toFileType(rs.getInt(columnName));
    }

    @Override
    public MsgFileType getResult(ResultSet rs, int columnIndex) throws SQLException {
        return MsgFileType.toFileType(rs.getInt(columnIndex));
    }

    @Override
    public MsgFileType getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return MsgFileType.toFileType(cs.getInt(columnIndex));
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, MsgFileType msgFileType, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, msgFileType.getType());
    }

    @Override
    public MsgFileType getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return MsgFileType.toFileType(resultSet.getInt(s));
    }

    @Override
    public MsgFileType getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return MsgFileType.toFileType(resultSet.getInt(i));
    }

    @Override
    public MsgFileType getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return MsgFileType.toFileType(callableStatement.getInt(i));
    }
}