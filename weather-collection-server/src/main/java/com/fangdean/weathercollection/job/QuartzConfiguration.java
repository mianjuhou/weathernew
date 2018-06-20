package com.fangdean.weathercollection.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail weatherSyncDataJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity("weatherSyncDataJobDetail")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger weatherSyncDataTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(20)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(weatherSyncDataJobDetail())
                .withIdentity("weatherSyncDataTrigger")
                .withSchedule(simpleScheduleBuilder)
                .build();
    }

}
