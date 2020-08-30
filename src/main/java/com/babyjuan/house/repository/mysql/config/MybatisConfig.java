package com.babyjuan.house.repository.mysql.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: hjg
 * @Date: Create in 2018/12/9 11:27
 * @Description:
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.babyjuan.house.repository.mysql")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * @param sqlSessionFactory 无需手动覆盖，否则某些自动配置加载不了，如mybatis的mapper.xml
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
