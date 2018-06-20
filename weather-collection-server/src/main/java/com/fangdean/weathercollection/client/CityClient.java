package com.fangdean.weathercollection.client;

import com.fangdean.weathercollection.model.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "weather-city-server")
public interface CityClient {

    @RequestMapping("/city/list")
    public List<City> listCity();

}
