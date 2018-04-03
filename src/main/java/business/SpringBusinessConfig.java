package business;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by Zhao Qing on 2017/11/14.
 * 非Web组件加载（Dao、Service...）
 */
@Configuration
@EnableJpaRepositories
@ComponentScan
public class SpringBusinessConfig {
    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driver;

    //数据库种类
    @Bean
    //通过datasource得到数据库connection
    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
        url = "jdbc:mysql://192.9.99.150:3306/ctsida?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
        username = "root";
        password = "1234";
        driver = "com.mysql.jdbc.Driver";

        //DriverManagerDataSource只要有连接就建立一个connection，没有连接池的作用
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    //通过JdbcTemplate实现查询操作，DataSource --> JdbcTemplate --> Dao --> Service --> Action/Servlet ？？？？
    public JdbcTemplate setupjdbcTemplate() throws Exception{
        return new JdbcTemplate(dataSource());
    }

    @Bean
    //JpaTransactionManager事务管理器，支持各种数据访问框架的管理
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    //jpa适配器
    @Bean
    //JpaVendorAdapter设置jpa实现厂商的特定属性，
    // HibernateJpaVendorAdapter，OpenJpaVendorAdapter，EclipseJpaVendorAdapter，TopLinkJpaVenderAdapter
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setDatabase(Database.H2);
//        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setShowSql(false);
        jpaVendorAdapter.setGenerateDdl(true);
        jpaVendorAdapter.setDatabase(Database.MYSQL);
        return jpaVendorAdapter;
    }

    //表示层(struts)、业务层(spring)、持久层(hibernate)
    // 配置容器管理类型的JPA（Java持久层API）
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
        lemfb.setDataSource(dataSource());
        lemfb.setJpaVendorAdapter(jpaVendorAdapter());
//        lemfb.setPackagesToScan("com.acme");
        lemfb.setPackagesToScan("business");
        return lemfb;
    }
}
