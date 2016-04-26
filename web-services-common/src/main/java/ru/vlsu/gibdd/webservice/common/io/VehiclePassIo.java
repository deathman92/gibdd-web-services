//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:26 PM MSK 
//


package ru.vlsu.gibdd.webservice.common.io;

import java.io.Serializable;
import java.time.Year;
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


/**
 * <p>Java class for VehiclePass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehiclePass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="vin" type="{http://vlsu.ru/schema/vehicle}VIN"/>
 *         &lt;element name="model" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="category" type="{http://vlsu.ru/schema/vehicle}Category"/>
 *         &lt;element name="built_year" type="{http://www.w3.org/2001/XMLSchema}gYear"/>
 *         &lt;element name="engine_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chassis_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="body_number" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="body_color" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehiclePass", namespace = "http://vlsu.ru/schema/vehicle", propOrder = {

})
public class VehiclePassIo
    extends AbstractIo
    implements Serializable, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String vin;
    @XmlElement(required = true)
    protected String model;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected CategoryIo category;
    @XmlElement(name = "built_year", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter2 .class)
    @XmlSchemaType(name = "gYear")
    protected Year builtYear;
    @XmlElement(name = "engine_number", required = true)
    protected String engineNumber;
    @XmlElement(name = "chassis_number", required = true)
    protected String chassisNumber;
    @XmlElement(name = "body_number", required = true, nillable = true)
    protected String bodyNumber;
    @XmlElement(name = "body_color", required = true)
    protected String bodyColor;

    /**
     * Gets the value of the vin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVin() {
        return vin;
    }

    /**
     * Sets the value of the vin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVin(String value) {
        this.vin = value;
    }

    /**
     * Gets the value of the model property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the value of the model property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModel(String value) {
        this.model = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryIo }
     *     
     */
    public CategoryIo getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryIo }
     *     
     */
    public void setCategory(CategoryIo value) {
        this.category = value;
    }

    /**
     * Gets the value of the builtYear property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Year getBuiltYear() {
        return builtYear;
    }

    /**
     * Sets the value of the builtYear property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuiltYear(Year value) {
        this.builtYear = value;
    }

    /**
     * Gets the value of the engineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEngineNumber() {
        return engineNumber;
    }

    /**
     * Sets the value of the engineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEngineNumber(String value) {
        this.engineNumber = value;
    }

    /**
     * Gets the value of the chassisNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChassisNumber() {
        return chassisNumber;
    }

    /**
     * Sets the value of the chassisNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChassisNumber(String value) {
        this.chassisNumber = value;
    }

    /**
     * Gets the value of the bodyNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodyNumber() {
        return bodyNumber;
    }

    /**
     * Sets the value of the bodyNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodyNumber(String value) {
        this.bodyNumber = value;
    }

    /**
     * Gets the value of the bodyColor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBodyColor() {
        return bodyColor;
    }

    /**
     * Sets the value of the bodyColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBodyColor(String value) {
        this.bodyColor = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof VehiclePassIo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final VehiclePassIo that = ((VehiclePassIo) object);
        {
            String lhsVin;
            lhsVin = this.getVin();
            String rhsVin;
            rhsVin = that.getVin();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vin", lhsVin), LocatorUtils.property(thatLocator, "vin", rhsVin), lhsVin, rhsVin)) {
                return false;
            }
        }
        {
            String lhsModel;
            lhsModel = this.getModel();
            String rhsModel;
            rhsModel = that.getModel();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "model", lhsModel), LocatorUtils.property(thatLocator, "model", rhsModel), lhsModel, rhsModel)) {
                return false;
            }
        }
        {
            String lhsType;
            lhsType = this.getType();
            String rhsType;
            rhsType = that.getType();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "type", lhsType), LocatorUtils.property(thatLocator, "type", rhsType), lhsType, rhsType)) {
                return false;
            }
        }
        {
            CategoryIo lhsCategory;
            lhsCategory = this.getCategory();
            CategoryIo rhsCategory;
            rhsCategory = that.getCategory();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "category", lhsCategory), LocatorUtils.property(thatLocator, "category", rhsCategory), lhsCategory, rhsCategory)) {
                return false;
            }
        }
        {
            Year lhsBuiltYear;
            lhsBuiltYear = this.getBuiltYear();
            Year rhsBuiltYear;
            rhsBuiltYear = that.getBuiltYear();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "builtYear", lhsBuiltYear), LocatorUtils.property(thatLocator, "builtYear", rhsBuiltYear), lhsBuiltYear, rhsBuiltYear)) {
                return false;
            }
        }
        {
            String lhsEngineNumber;
            lhsEngineNumber = this.getEngineNumber();
            String rhsEngineNumber;
            rhsEngineNumber = that.getEngineNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "engineNumber", lhsEngineNumber), LocatorUtils.property(thatLocator, "engineNumber", rhsEngineNumber), lhsEngineNumber, rhsEngineNumber)) {
                return false;
            }
        }
        {
            String lhsChassisNumber;
            lhsChassisNumber = this.getChassisNumber();
            String rhsChassisNumber;
            rhsChassisNumber = that.getChassisNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "chassisNumber", lhsChassisNumber), LocatorUtils.property(thatLocator, "chassisNumber", rhsChassisNumber), lhsChassisNumber, rhsChassisNumber)) {
                return false;
            }
        }
        {
            String lhsBodyNumber;
            lhsBodyNumber = this.getBodyNumber();
            String rhsBodyNumber;
            rhsBodyNumber = that.getBodyNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bodyNumber", lhsBodyNumber), LocatorUtils.property(thatLocator, "bodyNumber", rhsBodyNumber), lhsBodyNumber, rhsBodyNumber)) {
                return false;
            }
        }
        {
            String lhsBodyColor;
            lhsBodyColor = this.getBodyColor();
            String rhsBodyColor;
            rhsBodyColor = that.getBodyColor();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "bodyColor", lhsBodyColor), LocatorUtils.property(thatLocator, "bodyColor", rhsBodyColor), lhsBodyColor, rhsBodyColor)) {
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
            String theVin;
            theVin = this.getVin();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vin", theVin), currentHashCode, theVin);
        }
        {
            String theModel;
            theModel = this.getModel();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "model", theModel), currentHashCode, theModel);
        }
        {
            String theType;
            theType = this.getType();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "type", theType), currentHashCode, theType);
        }
        {
            CategoryIo theCategory;
            theCategory = this.getCategory();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "category", theCategory), currentHashCode, theCategory);
        }
        {
            Year theBuiltYear;
            theBuiltYear = this.getBuiltYear();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "builtYear", theBuiltYear), currentHashCode, theBuiltYear);
        }
        {
            String theEngineNumber;
            theEngineNumber = this.getEngineNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "engineNumber", theEngineNumber), currentHashCode, theEngineNumber);
        }
        {
            String theChassisNumber;
            theChassisNumber = this.getChassisNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "chassisNumber", theChassisNumber), currentHashCode, theChassisNumber);
        }
        {
            String theBodyNumber;
            theBodyNumber = this.getBodyNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bodyNumber", theBodyNumber), currentHashCode, theBodyNumber);
        }
        {
            String theBodyColor;
            theBodyColor = this.getBodyColor();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "bodyColor", theBodyColor), currentHashCode, theBodyColor);
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
            String theVin;
            theVin = this.getVin();
            strategy.appendField(locator, this, "vin", buffer, theVin);
        }
        {
            String theModel;
            theModel = this.getModel();
            strategy.appendField(locator, this, "model", buffer, theModel);
        }
        {
            String theType;
            theType = this.getType();
            strategy.appendField(locator, this, "type", buffer, theType);
        }
        {
            CategoryIo theCategory;
            theCategory = this.getCategory();
            strategy.appendField(locator, this, "category", buffer, theCategory);
        }
        {
            Year theBuiltYear;
            theBuiltYear = this.getBuiltYear();
            strategy.appendField(locator, this, "builtYear", buffer, theBuiltYear);
        }
        {
            String theEngineNumber;
            theEngineNumber = this.getEngineNumber();
            strategy.appendField(locator, this, "engineNumber", buffer, theEngineNumber);
        }
        {
            String theChassisNumber;
            theChassisNumber = this.getChassisNumber();
            strategy.appendField(locator, this, "chassisNumber", buffer, theChassisNumber);
        }
        {
            String theBodyNumber;
            theBodyNumber = this.getBodyNumber();
            strategy.appendField(locator, this, "bodyNumber", buffer, theBodyNumber);
        }
        {
            String theBodyColor;
            theBodyColor = this.getBodyColor();
            strategy.appendField(locator, this, "bodyColor", buffer, theBodyColor);
        }
        return buffer;
    }

}
