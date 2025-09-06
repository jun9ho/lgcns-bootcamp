package com.lgcns.inspire_restjpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")//모든 API 경로
                .allowedHeaders("*")
                .allowedOriginPatterns("http://localhost:3000")
                .allowedMethods("GET","POST","DELETE")
                .allowCredentials(true)//인증 허용
                .exposedHeaders("Authorization","Refresh-Token");
                //앞에 acces, 뒤가 refresh                
    }
}
