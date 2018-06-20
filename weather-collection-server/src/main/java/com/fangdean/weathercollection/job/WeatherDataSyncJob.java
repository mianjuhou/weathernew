package com.fangdean.weathercollection.job;

import com.fangdean.weathercollection.model.City;
import com.fangdean.weathercollection.service.WeatherCityService;
import com.fangdean.weathercollection.service.WeatherCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherCollectionService weatherCollectionService;

    @Autowired
    private WeatherCityService weatherCityService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("WeatherDataSyncJob ......");
        try {
            logger.info("sync starter..");
            List<City> cities = weatherCityService.listCity();

            cities.forEach(city -> {
                weatherCollectionService.syncDataByCityId(city.getCityId());
            });
            logger.info("sync done!");
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }
}
