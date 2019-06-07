package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author 浙江大学经济学院/朱 逸清
 * 
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ServerApplication {
      public static void main(String[] args) {
          SpringApplication.run(ServerApplication.class, args);
      }
      
}