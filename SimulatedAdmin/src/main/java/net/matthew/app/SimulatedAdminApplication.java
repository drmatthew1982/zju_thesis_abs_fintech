package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author matthew.yiqing.zhu/Zhu Yiqing  浙江大学
 * 
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SimulatedAdminApplication {
      public static void main(String[] args) {
          SpringApplication.run(SimulatedAdminApplication.class, args);
      }
      
}