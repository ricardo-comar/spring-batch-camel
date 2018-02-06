package br.comar.ricardo.stuff.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringApacheCamelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApacheCamelApplication.class, args);
    }
}

