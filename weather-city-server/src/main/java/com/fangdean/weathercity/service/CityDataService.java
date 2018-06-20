package com.fangdean.weathercity.service;

import com.fangdean.weathercity.model.City;
import com.fangdean.weathercity.model.CityWrapper;
import com.fangdean.weathercity.util.XmlBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataService {

    public List<City> listCity() throws IOException, JAXBException {
        Resource resource = new ClassPathResource("citypart.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }
        CityWrapper cityWrapper = (CityWrapper) XmlBuilder.xmlStrTpObject(CityWrapper.class, stringBuffer.toString());
        return cityWrapper.getCityList().getCityList();
    }

}
