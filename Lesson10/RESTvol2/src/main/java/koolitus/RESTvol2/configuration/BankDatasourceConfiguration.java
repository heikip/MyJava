package koolitus.RESTvol2.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BankDatasourceConfiguration {

    @Bean("dataSource1")
    public DataSource dataSource1(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost/andmebaasliqui");
        dataSource.setPassword("dockerpostgre");
        dataSource.setUsername("postgres");
        return dataSource;
    }

    @Bean("dataSource2")
    public DataSource dataSource2(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setPassword("dockerpostgre");
        dataSource.setUsername("postgres");
        dataSource.setUrl("jdbc:postgresql://localhost/bankarchive");
        return dataSource;
    }

    @Bean("namedjdbctemplate1")
    public NamedParameterJdbcTemplate jdbcTemplate1(@Qualifier("dataSource1") DataSource dataSource1){
        return new NamedParameterJdbcTemplate(dataSource1);
    }

    @Bean("namedjdbctemplate2")
    public NamedParameterJdbcTemplate jdbcTemplate2(@Qualifier("dataSource2") DataSource dataSource2){
        return new NamedParameterJdbcTemplate(dataSource2);
    }
}
