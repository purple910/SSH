package com.company.converter;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 1.   config.xml
 * <typeHandlers>
 *         <typeHandler handler="com.company.converter.BooleanAndIntConverter" javaType="Boolean" jdbcType="INTEGER"/>
 *</typeHandlers>
 *2.    *mapper.xml
 * <resultMap id="peopleResult" type="people">
 *     <id property="id" column="id"/>
 *     <result column="name" property="name"/>
 *     <result property="age" column="age"/>
 *     <result property="sex" column="sex" javaType="boolean" jdbcType="INTEGER"/>
 * </resultMap>
 * <select id="queryPeopleWithConverter" parameterType="int" resultMap="peopleResult">
 *      select * from people where id = #{id};
 * </select>
 *
 * @program: mybatis-01 com.company.converter.BooleanAndIntConverter
 * @description: 转换器 int boolean
 * @author: fate
 * @create: 2019-09-23 18:43
 **/

//public class BooleanAndIntConverter implements TypeHandler {  //实现接口，比较复杂 这是根本
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean> {  //这个简单一点


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        if(aBoolean){
            preparedStatement.setInt(i,1);
        }else {
            preparedStatement.setInt(i,0);
        }
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt("sex");
        if(sex == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        return sex == 1?true:false;
    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int anInt = callableStatement.getInt(i);
        return anInt ==1 ? true:false;
    }



}
