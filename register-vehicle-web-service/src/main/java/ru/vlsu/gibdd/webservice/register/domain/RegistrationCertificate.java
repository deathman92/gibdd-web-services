package ru.vlsu.gibdd.webservice.register.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Entity
public class RegistrationCertificate extends AbstractDomain {

    @Column(nullable = false, unique = true)
    private String registrationNumber;
    @Column(nullable = false)
    private String issuePlace;
    @Column(nullable = false)
    private LocalDate issueDate;
    @OneToOne(optional = false)
    private VehiclePass vehicle;
    @ManyToOne(optional = false)
    private Owner owner;

    //region Getters and Setters
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getIssuePlace() {
        return issuePlace;
    }

    public void setIssuePlace(String issuePlace) {
        this.issuePlace = issuePlace;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public VehiclePass getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehiclePass vehicle) {
        this.vehicle = vehicle;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegistrationCertificate that = (RegistrationCertificate) o;
        return Objects.equal(registrationNumber, that.registrationNumber) &&
                Objects.equal(issuePlace, that.issuePlace) &&
                Objects.equal(issueDate, that.issueDate) &&
                Objects.equal(vehicle, that.vehicle) &&
                Objects.equal(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), registrationNumber, issuePlace, issueDate, vehicle, owner);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("registrationNumber", registrationNumber)
                .add("issuePlace", issuePlace)
                .add("issueDate", issueDate)
                .add("vehicle", vehicle)
                .add("owner", owner)
                .toString();
    }
}
