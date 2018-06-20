package com.fangdean.weatherreport.service;

import com.fangdean.weatherreport.client.ZuulClient;
import com.fangdean.weatherreport.model.City;
import com.fangdean.weatherreport.model.Weather;
import com.fangdean.weatherreport.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherReportService {

    @Autowired
    private ZuulClient zuulClient;

    public Weather getWeatherByCityId(String cityId) {
        WeatherResponse response = zuulClient.getWeatherByCityId(cityId);
        if (response == null) {
            return null;
        }
        return response.getData();
    }

    public List<City> listCity() {
        return zuulClient.listCity();
    }
}
