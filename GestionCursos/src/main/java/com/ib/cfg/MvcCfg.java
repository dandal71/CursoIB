package com.ib.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ib.formatter.DateFormatter;

@Configuration
public class MvcCfg implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/home");
        registry.addViewController("/starter").setViewName("starter");
        registry.addViewController("/security/login").setViewName("/security/login");
        //registry.addViewController("/admin/usuario").setViewName("/admin/usuario-lista");
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(dateFormatter());
    }
}
