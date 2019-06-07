package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author 浙江-大学-朱逸清
 * 
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SimulatedBankApplication {
      public static void main(String[] args) {
          SpringApplication.run(SimulatedBankApplication.class, args);
      }
      
}