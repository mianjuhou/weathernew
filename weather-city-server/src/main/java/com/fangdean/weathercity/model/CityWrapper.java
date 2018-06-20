package com.fangdean.weathercity.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityWrapper {

    @XmlElement(name = "c")
    private CityList cityList;

    public CityList getCityList() {
        return cityList;
    }

    public void setCityList(CityList cityList) {
        this.cityList = cityList;
    }
}
