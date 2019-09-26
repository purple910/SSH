package com.company.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis-02 com.company.test.Test
 * @description: 驱动
 * @author: fate
 * @create: 2019-09-26 14:09
 **/
public class Test {
    public static void main(String[] args) throws InvalidConfigurationException, InterruptedException, SQLException, IOException, XMLParserException {


        //逆向工程的可行类
        File file = new File("src/generator.xml");
        List<String > warning = new ArrayList<>();

        ConfigurationParser parser = new ConfigurationParser(warning);
        Configuration configuration = null;

            configuration = parser.parseConfiguration(file);


        DefaultShellCallback shellCallback = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(configuration,shellCallback,warning);
        generator.generate(null);
    }
}
