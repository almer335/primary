package com.primary.core;

import org.springframework.context.annotation.*;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource(value = "classpath:properties/default.properties", encoding = "UTF-8")
@ComponentScan(basePackages = "com.primary")
public class SpringConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
