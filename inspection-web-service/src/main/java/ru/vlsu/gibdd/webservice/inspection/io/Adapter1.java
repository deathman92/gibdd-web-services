//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:34 PM MSK 
//


package ru.vlsu.gibdd.webservice.inspection.io;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, LocalDate>
{


    public LocalDate unmarshal(String value) {
        return (ru.vlsu.gibdd.webservice.common.util.DatatypeIoConverterUtils.parseXSDDate(value));
    }

    public String marshal(LocalDate value) {
        return (ru.vlsu.gibdd.webservice.common.util.DatatypeIoConverterUtils.printXSDDate(value));
    }

}
