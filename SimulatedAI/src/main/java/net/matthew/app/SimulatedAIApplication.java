package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * 
 * @author 浙大 导师：罗德明 作者：Matthew Zhu
 * @see 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
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