package com.example.demo.config.dao;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class SessionFactoryConfiguration {//SessionFactory用于做事务的提交
    @Value("${mybatis_config_file}")       //mybatis-config.xml配置文件的路径
    private String mybatisConfigFilePath;
    @Value("${mapper_path}")                //mybatis mapper 文件所在的路径
    private String mapperPath;
    @Autowired
    private DataSource dataSource;
    @Value("${entity_package}")
    private String entityPackage;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFilePath));
        //设置mybatisConfiguration的扫描路径，即mybatis-config.xml的配置文件
        //mybatis的配置由两部分组成：mybatis-config.xml以及mapper文件，
        // mapper文件用于实现dao层的相关操作，将前台发送的对于数据库的请求，转换为数据库能识别的语言，即SQL语句
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  //指定mapper的路径
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        //指定package的扫描路径,mapperPath就是mapper文件的存储路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);            //映射实体类,指定实体类package的扫描路径
        return sqlSessionFactoryBean;
    }
}
