package com.zl.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(JSONObject.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MySqlJsonHandler extends BaseTypeHandler<JSONObject> {


    /**
     * 设置非空参数
     * @param ps
     * @param i
     * @param jsonObject
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JSONObject jsonObject, JdbcType jdbcType) throws SQLException {
        ps.setString(i,String.valueOf(jsonObject.toJSONString()));
    }

    /**
     * 根据列名，获取可以为空的结果
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public JSONObject getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String sqlJson = resultSet.getString(s);
        if (null != sqlJson){
            return JSONObject.parseObject(sqlJson);
        }
        return null;
    }

    /**
     * 根据列索引，获取可以为空的结果
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public JSONObject getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String sqlJson = resultSet.getString(i);
        if (null != sqlJson){
            return JSONObject.parseObject(sqlJson);
        }
        return null;

    }

    @Override
    public JSONObject getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String sqlJson=callableStatement.getString(i);
        if(null !=  sqlJson){
            return  JSONObject.parseObject(sqlJson);
        }
        return null;
    }


}
