//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:34 PM MSK 
//


package ru.vlsu.gibdd.webservice.inspection.io;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
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
 *         &lt;element name="inspection_list" type="{http://vlsu.ru/schema/inspection}Inspection" maxOccurs="unbounded"/>
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
    "inspectionList"
})
@XmlRootElement(name = "AddInspectionResponse")
public class AddInspectionResponseIo
    extends AbstractIo
    implements Serializable, Equals, HashCode, ToString
{

    @XmlElement(name = "inspection_list", required = true)
    protected List<InspectionIo> inspectionList;

    /**
     * Gets the value of the inspectionList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inspectionList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInspectionList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InspectionIo }
     * 
     * 
     */
    public List<InspectionIo> getInspectionList() {
        if (inspectionList == null) {
            inspectionList = new ArrayList<InspectionIo>();
        }
        return this.inspectionList;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof AddInspectionResponseIo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final AddInspectionResponseIo that = ((AddInspectionResponseIo) object);
        {
            List<InspectionIo> lhsInspectionList;
            lhsInspectionList = (((this.inspectionList!= null)&&(!this.inspectionList.isEmpty()))?this.getInspectionList():null);
            List<InspectionIo> rhsInspectionList;
            rhsInspectionList = (((that.inspectionList!= null)&&(!that.inspectionList.isEmpty()))?that.getInspectionList():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inspectionList", lhsInspectionList), LocatorUtils.property(thatLocator, "inspectionList", rhsInspectionList), lhsInspectionList, rhsInspectionList)) {
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
            List<InspectionIo> theInspectionList;
            theInspectionList = (((this.inspectionList!= null)&&(!this.inspectionList.isEmpty()))?this.getInspectionList():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inspectionList", theInspectionList), currentHashCode, theInspectionList);
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
            List<InspectionIo> theInspectionList;
            theInspectionList = (((this.inspectionList!= null)&&(!this.inspectionList.isEmpty()))?this.getInspectionList():null);
            strategy.appendField(locator, this, "inspectionList", buffer, theInspectionList);
        }
        return buffer;
    }

}
