package com.hongdatchy.bookcar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.TimeZone;

@SpringBootApplication
@EnableSwagger2
public class BookCarApplication implements CommandLineRunner {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/**")).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(BookCarApplication.class, args);
    }

    @Autowired
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @Override
    public void run(String... args) {
        //        set timezone cho backend
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+7"));
//        set timezone cho controller
        objectMapper.setTimeZone(TimeZone.getDefault());
        System.out.println("Started server successfully");
    }
}
