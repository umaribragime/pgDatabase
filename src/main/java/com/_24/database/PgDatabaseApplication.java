package com._24.database;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class PgDatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(PgDatabaseApplication.class, args);
    }

}
//@SpringBootApplication
//@Log
//public class PgDatabaseApplication implements CommandLineRunner {
//
//    private  final DataSource dataSource;
//
//    public PgDatabaseApplication(final DataSource dataSource){ this.dataSource = dataSource; }
//
//    public static void main(String[] args){ SpringApplication.run(PgDatabaseApplication.class, args); }
//
//    @Override
//    public void run(final String... args){
//        log.info("Datasource: " + dataSource.toString());
//        final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
//        restTemplate.execute("select 1");
//    }
//}
