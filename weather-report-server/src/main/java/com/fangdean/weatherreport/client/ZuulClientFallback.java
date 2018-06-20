package com.fangdean.weatherreport.client;

import com.fangdean.weatherreport.model.City;
import com.fangdean.weatherreport.model.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZuulClientFallback implements ZuulClient {

    @Override
    public List<City> listCity() {
        List<City> cityList=new ArrayList<>();
        City city = new City();
        city.setCityId("101010100");
        city.setCityName("北京");
        city.setCityCode("beijing");
        city.setProvince("北京");
        cityList.add(city);
        return cityList;
    }

    @Override
    public WeatherResponse getWeatherByCityId(String cityId) {
        System.out.println("ZuulClientFallback.getWeatherByCityId");
        return null;
    }
}
