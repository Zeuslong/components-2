package cn.vxnm.component.springboot.mybatis.multi.db.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "cn.vxnm.component.springboot.mybatis.multi.db.mapper.mysql1", sqlSessionFactoryRef = "mysql1SqlSessionFactory")
public class Mysql1DatasourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.mysql1")
    public DataSource mysql1Datasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory mysql1SqlSessionFactory(@Qualifier("mysql1Datasource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/mysql1/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager mysql1DataSourceTransactionManager(@Qualifier("mysql1Datasource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
