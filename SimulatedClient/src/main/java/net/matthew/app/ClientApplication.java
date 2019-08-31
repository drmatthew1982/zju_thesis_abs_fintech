package net.matthew.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * @author  浙江大学 导师：罗德明 作者：朱逸清
 * @see 基于国内市场资产证券化风险事件分析与区块链应用的金融科技设计
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ClientApplication {      
      public static void main(String[] args) {
          SpringApplication.run(ClientApplication.class, args);
      }
}

