package org.scoula.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration : 설정
@Configuration
@MapperScan(basePackages = {"org.scoula.mapper"}) //mapper의 위치 알려주기
// 어떤 경로에서 property를 가져올지 설정(classpath를 붙여줘야 프로젝트의 루트로 접근)
//그냥 /를 사용하면 weapp 폴더가 루트가 된다.
@PropertySource({"classpath:/application.properties"})
public class RootConfig {
    @Value("${jdbc.driver}") String driver;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

//        설정 객체에 데이터베이스 연결 정보를 설정
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);

//        HikariDataSource 객체 생성 후 설정을 적용
        HikariDataSource dataSource = new HikariDataSource(config);
        return dataSource;
    }
//    application scope
    @Autowired
    ApplicationContext applicationContext;

//    mybatis mdl SqlSessionFactory를 빈으로 등록해주는 메소드
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
//        SqlSessionFactoryBean 객체 생성
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        mybaits 설정 파일의 위치 알려줌
        sqlSessionFactory.setConfigLocation(applicationContext.getResource("classpath:/mybatis-config.xml"));
//        DataSource 설정
        sqlSessionFactory.setDataSource(dataSource());
        return (SqlSessionFactory) sqlSessionFactory.getObject();
    }
//    DataSourceTransactionManager를 빈으로 등록하는 메소드
    @Bean
    public DataSourceTransactionManager transactionManager() {
//        DataSourceTransactionManager 객체 생성
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSource());
        return manager;
    }
}
