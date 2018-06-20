package com.fangdean.weathercollection.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherCollectionService {
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";
    public static final int TIMEOUT = 30;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void syncDataByCityId(String cityId) {
        String url = WEATHER_URI + "?citykey=" + cityId;
        saveWeatherData(url);
    }

    public void saveWeatherData(String url) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        if (responseEntity.getStatusCodeValue() == 200) {
            String body = responseEntity.getBody();
            ops.set(url, body, TIMEOUT, TimeUnit.MINUTES);
        }
    }
}
