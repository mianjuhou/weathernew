package com.fangdean.weatherreport.controller;

import com.fangdean.weatherreport.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Controller
@RequestMapping("/report")
@RefreshScope
public class WeatherReportController {

    @Value("${neo.hello}")
    private String domain;

    @Autowired
    private WeatherReportService weatherReportService;

    @RequestMapping("/cityId/{cityId}")
    public ModelAndView getDataByCityId(@PathVariable("cityId") String cityId, Model model) throws IOException, JAXBException {
        model.addAttribute("title", "房德安的天气预报");
        model.addAttribute("domain",domain);
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", weatherReportService.listCity());
        model.addAttribute("report", weatherReportService.getWeatherByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
