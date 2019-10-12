package com.example.my;

/**
 * @program: mybatis-mapper com.example.my.MySelectProvider
 * @description:
 * @author: fate
 * @create: 2019-10-12 23:39
 **/
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

public class MySelectProvider extends MapperTemplate {


    public MySelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 查询全部结果
     *
     * @param ms
     * @return
     */
    public String selectStudent(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
//        sql.append(SqlHelper.orderByDefault(entityClass));
        sql.append("order by stu_no desc");
        return sql.toString();
    }

}