package com.example.injector.methods;

import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @program: mybatis-plus-01 com.example.injector.methods.MyDelete
 * @description:
 * @author: fate
 * @create: 2019-10-11 23:03
 **/
public class MyDelete extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        String sql;
        SqlMethod sqlMethod = SqlMethod.LOGIC_DELETE;
        //逻辑删除
//        if (tableInfo.isLogicDelete()) {
//            sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), sqlLogicSet(tableInfo),
//                    sqlWhereEntityWrapper(true, tableInfo),
//                    sqlComment());
//            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
//            return addUpdateMappedStatement(mapperClass, modelClass, sqlMethod.getMethod(), sqlSource);
//        }
        //真实删除
            sql = "delete from mybatis_plus_student where stu_no>3";
            SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
            return this.addDeleteMappedStatement(mapperClass, "deleteAllStudents", sqlSource);
    }
}
