package com.fangdean.weathercollection.service;

import com.fangdean.weathercollection.client.CityClient;
import com.fangdean.weathercollection.model.City;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class WeatherCityService {

    @Autowired
    private CityClient cityClient;

    @RequestMapping("/city/list")
    @HystrixCommand(fallbackMethod = "defaultCity")
    public List<City> listCity() {
        return cityClient.listCity();
    }

    public List<City> defaultCity() {
        System.out.println("City Data Server is Down!");
        return null;
    }
}
