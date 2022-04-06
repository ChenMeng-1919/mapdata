package com.a5ibug.lifemap;

import com.a5ibug.lifemap.common.api.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class LifeMapApplication {
    public static ConfigurableApplicationContext run;

    public static void main(String[] args) {
         run = SpringApplication.run(LifeMapApplication.class, args);

        /*ApplicationContext applicationContext = SpringUtil.getApplicationContext();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            log.info("{}"+beanDefinitionName,"获取的bean为");
        }*/
    }

}
