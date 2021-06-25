package cn.wangjia.spring.chapter3;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

/**
 * @author wangjiaq
 * @version 1.0
 * @date 2021/6/9
 */
/**
 *  JDBC：Java DataBase Connectivity，Java连接数据库和执行SQL语句的API
 *  JNDI：Java Naming and Directory Interface，Java命名和目录接口。JNDI是指使用数据源连接数据库的这种方式，简单地，可以将JNDI理解为所有Data Source的集合。
 *  DBCP：DataBase Connection Pool，数据库连接池。数据连接池就是连接数据库的进程的集合
 *  Data Source：数据源。就是将IP、数据库、用户名、密码封装起来对外只提供一个JNDI名称，在应用中只要调用这个JNDI就能连接数据库，而不需要在代码中写入用户名密码等信息。这样做的好处是，当用户名密码乃至数据库变化时只需要去修改JNDI的xml文件而不需要去修改代码。
 */
public class DataSourceConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                    .addScript("classpath:schema.sql")
                    .addScript("classpath:test-data.sql")
                    .build();
    }
    @Bean
    //@Profile("")
    public DataSource dataSourceTwo(){
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/myDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return (DataSource) jndiObjectFactoryBean.getObject();


    }
    @Bean
    public DataSource dataSourceThree(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:h2:tcp://dbserver/~/test");
        basicDataSource.setDriverClassName("org.b2.Driver");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("password");
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxActive(30);
        return basicDataSource;
    }



}
