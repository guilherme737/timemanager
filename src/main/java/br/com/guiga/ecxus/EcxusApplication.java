package br.com.guiga.ecxus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@SpringBootApplication
public class EcxusApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcxusApplication.class, args);
    }

}
