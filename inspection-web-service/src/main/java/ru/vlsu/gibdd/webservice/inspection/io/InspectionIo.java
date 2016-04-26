//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:34 PM MSK 
//


package ru.vlsu.gibdd.webservice.inspection.io;

import java.io.Serializable;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;
import ru.vlsu.gibdd.webservice.common.io.AbstractIo;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;


/**
 * <p>Java class for Inspection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Inspection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="inspector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vehicle" type="{http://vlsu.ru/schema/vehicle}VehiclePass"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Inspection", namespace = "http://vlsu.ru/schema/inspection", propOrder = {

})
public class InspectionIo
    extends AbstractIo
    implements Serializable, Equals, HashCode, ToString
{

    @XmlElement(namespace = "http://vlsu.ru/schema/inspection", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate date;
    @XmlElement(namespace = "http://vlsu.ru/schema/inspection", required = true)
    protected String inspector;
    @XmlElement(namespace = "http://vlsu.ru/schema/inspection", required = true)
    protected VehiclePassIo vehicle;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(LocalDate value) {
        this.date = value;
    }

    /**
     * Gets the value of the inspector property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInspector() {
        return inspector;
    }

    /**
     * Sets the value of the inspector property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInspector(String value) {
        this.inspector = value;
    }

    /**
     * Gets the value of the vehicle property.
     * 
     * @return
     *     possible object is
     *     {@link VehiclePassIo }
     *     
     */
    public VehiclePassIo getVehicle() {
        return vehicle;
    }

    /**
     * Sets the value of the vehicle property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehiclePassIo }
     *     
     */
    public void setVehicle(VehiclePassIo value) {
        this.vehicle = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof InspectionIo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final InspectionIo that = ((InspectionIo) object);
        {
            LocalDate lhsDate;
            lhsDate = this.getDate();
            LocalDate rhsDate;
            rhsDate = that.getDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "date", lhsDate), LocatorUtils.property(thatLocator, "date", rhsDate), lhsDate, rhsDate)) {
                return false;
            }
        }
        {
            String lhsInspector;
            lhsInspector = this.getInspector();
            String rhsInspector;
            rhsInspector = that.getInspector();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inspector", lhsInspector), LocatorUtils.property(thatLocator, "inspector", rhsInspector), lhsInspector, rhsInspector)) {
                return false;
            }
        }
        {
            VehiclePassIo lhsVehicle;
            lhsVehicle = this.getVehicle();
            VehiclePassIo rhsVehicle;
            rhsVehicle = that.getVehicle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vehicle", lhsVehicle), LocatorUtils.property(thatLocator, "vehicle", rhsVehicle), lhsVehicle, rhsVehicle)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            LocalDate theDate;
            theDate = this.getDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "date", theDate), currentHashCode, theDate);
        }
        {
            String theInspector;
            theInspector = this.getInspector();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspector", theInspector), currentHashCode, theInspector);
        }
        {
            VehiclePassIo theVehicle;
            theVehicle = this.getVehicle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vehicle", theVehicle), currentHashCode, theVehicle);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            LocalDate theDate;
            theDate = this.getDate();
            strategy.appendField(locator, this, "date", buffer, theDate);
        }
        {
            String theInspector;
            theInspector = this.getInspector();
            strategy.appendField(locator, this, "inspector", buffer, theInspector);
        }
        {
            VehiclePassIo theVehicle;
            theVehicle = this.getVehicle();
            strategy.appendField(locator, this, "vehicle", buffer, theVehicle);
        }
        return buffer;
    }

}
