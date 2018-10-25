package com.app.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.app.services.filters.ErrorFilter;
import com.app.services.filters.PostFilter;
import com.app.services.filters.PreFilter;
import com.app.services.filters.RouteFilter;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerZuulApplication.class, args);
	}
	
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
}
