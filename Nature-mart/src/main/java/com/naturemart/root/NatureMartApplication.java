package com.naturemart.root;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableResourceServer
@EnableOAuth2Client
@EnableGlobalMethodSecurity(securedEnabled=true)
public class NatureMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(NatureMartApplication.class, args);              
	}
	
	@Bean
	public FilterRegistrationBean corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    
	    CorsConfiguration configAutenticacao = new CorsConfiguration();
	    configAutenticacao.setAllowCredentials(true);
	    //configAutenticacao.addAllowedOrigin("http://localhost:4200");
	    configAutenticacao.addAllowedOrigin("*");
	    configAutenticacao.addAllowedHeader("Authorization");
	    configAutenticacao.addAllowedHeader("Content-Type");
	    configAutenticacao.addAllowedHeader("Accept");
	    configAutenticacao.addAllowedMethod("POST");
	    configAutenticacao.addAllowedMethod("GET");
	    configAutenticacao.addAllowedMethod("DELETE");
	    configAutenticacao.addAllowedMethod("PUT");
	    configAutenticacao.addAllowedMethod("OPTIONS");
	    configAutenticacao.setMaxAge(3600L);
	    //source.registerCorsConfiguration("/oauth/token", configAutenticacao);
	    source.registerCorsConfiguration("/**", configAutenticacao); // Global for all paths
	    
	    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
	    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	    return bean;
	}

}
