//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:34 PM MSK 
//


package ru.vlsu.gibdd.webservice.inspection.io;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="inspector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vehicle_pass_list" type="{http://vlsu.ru/schema/vehicle}VehiclePass" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "date",
    "inspector",
    "vehiclePassList"
})
@XmlRootElement(name = "AddInspectionRequest")
public class AddInspectionRequestIo
    extends AbstractIo
    implements Serializable, Equals, HashCode, ToString
{

    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate date;
    @XmlElement(required = true)
    protected String inspector;
    @XmlElement(name = "vehicle_pass_list", required = true)
    protected List<VehiclePassIo> vehiclePassList;

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
     * Gets the value of the vehiclePassList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vehiclePassList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehiclePassList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehiclePassIo }
     * 
     * 
     */
    public List<VehiclePassIo> getVehiclePassList() {
        if (vehiclePassList == null) {
            vehiclePassList = new ArrayList<VehiclePassIo>();
        }
        return this.vehiclePassList;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AddInspectionRequestIo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AddInspectionRequestIo that = ((AddInspectionRequestIo) object);
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
            List<VehiclePassIo> lhsVehiclePassList;
            lhsVehiclePassList = (((this.vehiclePassList!= null)&&(!this.vehiclePassList.isEmpty()))?this.getVehiclePassList():null);
            List<VehiclePassIo> rhsVehiclePassList;
            rhsVehiclePassList = (((that.vehiclePassList!= null)&&(!that.vehiclePassList.isEmpty()))?that.getVehiclePassList():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "vehiclePassList", lhsVehiclePassList), LocatorUtils.property(thatLocator, "vehiclePassList", rhsVehiclePassList), lhsVehiclePassList, rhsVehiclePassList)) {
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
            List<VehiclePassIo> theVehiclePassList;
            theVehiclePassList = (((this.vehiclePassList!= null)&&(!this.vehiclePassList.isEmpty()))?this.getVehiclePassList():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "vehiclePassList", theVehiclePassList), currentHashCode, theVehiclePassList);
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
            List<VehiclePassIo> theVehiclePassList;
            theVehiclePassList = (((this.vehiclePassList!= null)&&(!this.vehiclePassList.isEmpty()))?this.getVehiclePassList():null);
            strategy.appendField(locator, this, "vehiclePassList", buffer, theVehiclePassList);
        }
        return buffer;
    }

}
