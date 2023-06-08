package com.minegoldminegone.minegoldminegone.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    CorsFilter corsFilter;
    
    /**
     * 「/login」というURLからlogin.htmlを呼び出す
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
  
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/**")
          .allowedOrigins("*")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
          .allowedHeaders("authorization", "content-type", "xsrf-token")
          .allowCredentials(false)
          .maxAge(3600)
          .exposedHeaders("Authorization");
    }
  
    public void addFilters(FilterRegistrationBean registration) {
      registration.setFilter(corsFilter);
      registration.addUrlPatterns("/*");
      registration.setName("corsFilter");
      registration.setOrder(1);
    }
}

