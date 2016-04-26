package ru.vlsu.gibdd.webservice.inspection.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Entity
public class Inspection extends AbstractDomain {

    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String inspector;
    @ManyToOne(optional = false)
    private VehiclePass vehicle;

    //region Getters and Setters
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public VehiclePass getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehiclePass vehicle) {
        this.vehicle = vehicle;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Inspection that = (Inspection) o;
        return Objects.equal(date, that.date) &&
                Objects.equal(inspector, that.inspector) &&
                Objects.equal(vehicle, that.vehicle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), date, inspector, vehicle);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("date", date)
                .add("inspector", inspector)
                .add("vehicle", vehicle)
                .toString();
    }
}
