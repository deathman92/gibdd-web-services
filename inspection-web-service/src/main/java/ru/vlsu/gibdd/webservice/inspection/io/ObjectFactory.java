//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:34 PM MSK 
//


package ru.vlsu.gibdd.webservice.inspection.io;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.vlsu.gibdd.webservice.inspection.io package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.vlsu.gibdd.webservice.inspection.io
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddInspectionResponseIo }
     * 
     */
    public AddInspectionResponseIo createAddInspectionResponseIo() {
        return new AddInspectionResponseIo();
    }

    /**
     * Create an instance of {@link InspectionIo }
     * 
     */
    public InspectionIo createInspectionIo() {
        return new InspectionIo();
    }

    /**
     * Create an instance of {@link CheckInspectionResponseIo }
     * 
     */
    public CheckInspectionResponseIo createCheckInspectionResponseIo() {
        return new CheckInspectionResponseIo();
    }

    /**
     * Create an instance of {@link AddInspectionRequestIo }
     * 
     */
    public AddInspectionRequestIo createAddInspectionRequestIo() {
        return new AddInspectionRequestIo();
    }

    /**
     * Create an instance of {@link CheckInspectionRequestIo }
     * 
     */
    public CheckInspectionRequestIo createCheckInspectionRequestIo() {
        return new CheckInspectionRequestIo();
    }

    /**
     * Create an instance of {@link CheckInspectionFaultIo }
     * 
     */
    public CheckInspectionFaultIo createCheckInspectionFaultIo() {
        return new CheckInspectionFaultIo();
    }

}
