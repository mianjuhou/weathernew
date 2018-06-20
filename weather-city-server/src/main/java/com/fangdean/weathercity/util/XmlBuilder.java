package com.fangdean.weathercity.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    public static Object xmlStrTpObject(Class<?> clazz, String xmlStr) throws IOException, JAXBException {
        Reader reader = new StringReader(xmlStr);

        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader) {
            reader.close();
        }

        return xmlObject;
    }

}
