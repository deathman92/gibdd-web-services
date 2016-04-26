package ru.vlsu.gibdd.webservice.common.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Embeddable
public class Registration {

    @Column(nullable = false)
    private String region;
    private String district;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private LocalDate date;

    // region Getters and Setters
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    // endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registration that = (Registration) o;
        return Objects.equal(region, that.region) &&
                Objects.equal(district, that.district) &&
                Objects.equal(city, that.city) &&
                Objects.equal(address, that.address) &&
                Objects.equal(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(region, district, city, address, date);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("region", region)
                .add("district", district)
                .add("city", city)
                .add("address", address)
                .add("date", date)
                .toString();
    }
}
