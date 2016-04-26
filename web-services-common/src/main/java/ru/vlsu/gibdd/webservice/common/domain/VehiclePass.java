package ru.vlsu.gibdd.webservice.common.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import org.hibernate.annotations.TypeDef;
import ru.vlsu.gibdd.webservice.common.type.YearType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Year;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Entity
@TypeDef(defaultForType = Year.class, typeClass = YearType.class)
public class VehiclePass extends AbstractDomain {

    @Column(nullable = false, unique = true)
    private String vin;
    @Column(nullable = false)
    private String model;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(nullable = false)
    private Year builtYear;
    @Column(nullable = false)
    private String engineNumber;
    @Column(nullable = false)
    private String chassisNumber;
    private String bodyNumber;
    @Column(nullable = false)
    private String bodyColor;

    public enum Category {
        A, B, C, D
    }

    // region Getters and Setters
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Year getBuiltYear() {
        return builtYear;
    }

    public void setBuiltYear(Year builtYear) {
        this.builtYear = builtYear;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getBodyNumber() {
        return bodyNumber;
    }

    public void setBodyNumber(String bodyNumber) {
        this.bodyNumber = bodyNumber;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }
    // endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VehiclePass that = (VehiclePass) o;
        return Objects.equal(vin, that.vin) &&
                Objects.equal(model, that.model) &&
                Objects.equal(type, that.type) &&
                category == that.category &&
                Objects.equal(builtYear, that.builtYear) &&
                Objects.equal(engineNumber, that.engineNumber) &&
                Objects.equal(chassisNumber, that.chassisNumber) &&
                Objects.equal(bodyNumber, that.bodyNumber) &&
                Objects.equal(bodyColor, that.bodyColor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), vin, model, type, category, builtYear, engineNumber, chassisNumber, bodyNumber, bodyColor);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("vin", vin)
                .add("model", model)
                .add("type", type)
                .add("category", category)
                .add("builtYear", builtYear)
                .add("engineNumber", engineNumber)
                .add("chassisNumber", chassisNumber)
                .add("bodyNumber", bodyNumber)
                .add("bodyColor", bodyColor)
                .toString();
    }
}
