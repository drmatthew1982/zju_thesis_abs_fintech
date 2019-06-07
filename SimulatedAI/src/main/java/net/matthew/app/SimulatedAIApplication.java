package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author matthew.yiqing.zhu/朱 逸清   浙大经济学院
 * 
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SimulatedAIApplication {
      public static void main(String[] args) {
          SpringApplication.run(SimulatedAIApplication.class, args);
      }
      
}