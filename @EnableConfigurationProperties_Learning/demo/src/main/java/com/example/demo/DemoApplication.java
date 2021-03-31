package com.example.demo;

import com.example.demo.config.DBConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(DBConfig.class)
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(DBConfig dbConfig, @Value("${db.host}") String host) {
        return (args) -> {
            System.out.println("user : " + dbConfig.getUsername() + "\n" + "password : " + dbConfig.getPassword() + "\n");

            dbConfig.getOthers().stream().forEach(System.out::println);

            dbConfig.getMap().forEach((k,v) -> {
                System.out.println("key : " + k + ", value : " + v);
            });

            System.out.println("DB Host is : " + host);
        };
    }

}
