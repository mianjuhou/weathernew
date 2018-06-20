package com.fangdean.weatherdata.service;

import com.fangdean.weatherdata.model.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherDataService.class);
    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_URI + "?citykey=" + cityId;
        return getWeatherResponse(url);
    }

    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_URI + "?city=" + cityName;
        return getWeatherResponse(url);
    }

    private WeatherResponse getWeatherResponse(String url) {
        try {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            String body = null;
            if (stringRedisTemplate.hasKey(url)) {
                logger.info("Redis has data");
                body = ops.get(url);
            } else {
                logger.info("Redis hasn't data");
                throw new RuntimeException("Redis hasn't data");
            }
            ObjectMapper mapper = new ObjectMapper();
            WeatherResponse response = mapper.readValue(body, WeatherResponse.class);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
