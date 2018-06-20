package com.fangdean.weathercity.controller;

import com.fangdean.weathercity.model.City;
import com.fangdean.weathercity.service.CityDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping("/list")
    public List<City> listCity() throws IOException, JAXBException {
        return cityDataService.listCity();
    }
}
