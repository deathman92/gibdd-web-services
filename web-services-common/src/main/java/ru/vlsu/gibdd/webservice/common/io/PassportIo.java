//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7-b41 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.04.26 at 10:04:26 PM MSK 
//


package ru.vlsu.gibdd.webservice.common.io;

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


/**
 * <p>Java class for Passport complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Passport">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="series">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="4"/>
 *               &lt;pattern value="[0-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="number">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;length value="6"/>
 *               &lt;pattern value="[0-9]+"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="issue_date" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="issued_by" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="registration" type="{http://vlsu.ru/schema/citizen}Registration"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Passport", propOrder = {

})
public class PassportIo
    extends AbstractIo
    implements Serializable, Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected String series;
    @XmlElement(required = true)
    protected String number;
    @XmlElement(name = "issue_date", required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    @XmlSchemaType(name = "date")
    protected LocalDate issueDate;
    @XmlElement(name = "issued_by", required = true)
    protected String issuedBy;
    @XmlElement(required = true)
    protected RegistrationIo registration;

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeries(String value) {
        this.series = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the issueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * Sets the value of the issueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueDate(LocalDate value) {
        this.issueDate = value;
    }

    /**
     * Gets the value of the issuedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssuedBy() {
        return issuedBy;
    }

    /**
     * Sets the value of the issuedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssuedBy(String value) {
        this.issuedBy = value;
    }

    /**
     * Gets the value of the registration property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationIo }
     *     
     */
    public RegistrationIo getRegistration() {
        return registration;
    }

    /**
     * Sets the value of the registration property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationIo }
     *     
     */
    public void setRegistration(RegistrationIo value) {
        this.registration = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof PassportIo)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final PassportIo that = ((PassportIo) object);
        {
            String lhsSeries;
            lhsSeries = this.getSeries();
            String rhsSeries;
            rhsSeries = that.getSeries();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "series", lhsSeries), LocatorUtils.property(thatLocator, "series", rhsSeries), lhsSeries, rhsSeries)) {
                return false;
            }
        }
        {
            String lhsNumber;
            lhsNumber = this.getNumber();
            String rhsNumber;
            rhsNumber = that.getNumber();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "number", lhsNumber), LocatorUtils.property(thatLocator, "number", rhsNumber), lhsNumber, rhsNumber)) {
                return false;
            }
        }
        {
            LocalDate lhsIssueDate;
            lhsIssueDate = this.getIssueDate();
            LocalDate rhsIssueDate;
            rhsIssueDate = that.getIssueDate();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "issueDate", lhsIssueDate), LocatorUtils.property(thatLocator, "issueDate", rhsIssueDate), lhsIssueDate, rhsIssueDate)) {
                return false;
            }
        }
        {
            String lhsIssuedBy;
            lhsIssuedBy = this.getIssuedBy();
            String rhsIssuedBy;
            rhsIssuedBy = that.getIssuedBy();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "issuedBy", lhsIssuedBy), LocatorUtils.property(thatLocator, "issuedBy", rhsIssuedBy), lhsIssuedBy, rhsIssuedBy)) {
                return false;
            }
        }
        {
            RegistrationIo lhsRegistration;
            lhsRegistration = this.getRegistration();
            RegistrationIo rhsRegistration;
            rhsRegistration = that.getRegistration();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "registration", lhsRegistration), LocatorUtils.property(thatLocator, "registration", rhsRegistration), lhsRegistration, rhsRegistration)) {
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
            String theSeries;
            theSeries = this.getSeries();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "series", theSeries), currentHashCode, theSeries);
        }
        {
            String theNumber;
            theNumber = this.getNumber();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "number", theNumber), currentHashCode, theNumber);
        }
        {
            LocalDate theIssueDate;
            theIssueDate = this.getIssueDate();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "issueDate", theIssueDate), currentHashCode, theIssueDate);
        }
        {
            String theIssuedBy;
            theIssuedBy = this.getIssuedBy();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "issuedBy", theIssuedBy), currentHashCode, theIssuedBy);
        }
        {
            RegistrationIo theRegistration;
            theRegistration = this.getRegistration();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "registration", theRegistration), currentHashCode, theRegistration);
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
            String theSeries;
            theSeries = this.getSeries();
            strategy.appendField(locator, this, "series", buffer, theSeries);
        }
        {
            String theNumber;
            theNumber = this.getNumber();
            strategy.appendField(locator, this, "number", buffer, theNumber);
        }
        {
            LocalDate theIssueDate;
            theIssueDate = this.getIssueDate();
            strategy.appendField(locator, this, "issueDate", buffer, theIssueDate);
        }
        {
            String theIssuedBy;
            theIssuedBy = this.getIssuedBy();
            strategy.appendField(locator, this, "issuedBy", buffer, theIssuedBy);
        }
        {
            RegistrationIo theRegistration;
            theRegistration = this.getRegistration();
            strategy.appendField(locator, this, "registration", buffer, theRegistration);
        }
        return buffer;
    }

}
