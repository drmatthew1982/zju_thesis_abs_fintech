package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ClientApplication {      
      public static void main(String[] args) {
          SpringApplication.run(ClientApplication.class, args);
      }
}

