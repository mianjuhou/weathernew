package com.fangdean.weatherreport.client;

import com.fangdean.weatherreport.model.City;
import com.fangdean.weatherreport.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "weather-zuul-server")
public interface ZuulClient {

    @RequestMapping("/city/city/list")
    public List<City> listCity();

    @RequestMapping("/weather/weather/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId);

}
