package ru.vlsu.gibdd.webservice.register.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Entity
public class Owner extends AbstractDomain {

    @Column(nullable = false)
    private String firstname;
    private String middlename;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private String region;
    private String district;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;

    //region Getters and Setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Owner owner = (Owner) o;
        return Objects.equal(firstname, owner.firstname) &&
                Objects.equal(middlename, owner.middlename) &&
                Objects.equal(lastname, owner.lastname) &&
                Objects.equal(region, owner.region) &&
                Objects.equal(district, owner.district) &&
                Objects.equal(city, owner.city) &&
                Objects.equal(address, owner.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), firstname, middlename, lastname, region, district, city, address);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("firstname", firstname)
                .add("middlename", middlename)
                .add("lastname", lastname)
                .add("region", region)
                .add("district", district)
                .add("city", city)
                .add("address", address)
                .toString();
    }
}
