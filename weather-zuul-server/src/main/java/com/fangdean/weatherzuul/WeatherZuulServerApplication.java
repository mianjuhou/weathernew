package com.fangdean.weatherzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class WeatherZuulServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherZuulServerApplication.class, args);
    }
}
