package ru.vlsu.gibdd.webservice.common.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Embeddable
public class Passport {

    @Column(nullable = false)
    private String series;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private LocalDate issueDate;
    @Column(nullable = false)
    private String issuedBy;
    @Embedded
    private Registration registration;

    // region Getters and Setters
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
    // endregion Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equal(series, passport.series) &&
                Objects.equal(number, passport.number) &&
                Objects.equal(issueDate, passport.issueDate) &&
                Objects.equal(issuedBy, passport.issuedBy) &&
                Objects.equal(registration, passport.registration);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(series, number, issueDate, issuedBy, registration);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("series", series)
                .add("number", number)
                .add("issueDate", issueDate)
                .add("issuedBy", issuedBy)
                .add("registration", registration)
                .toString();
    }
}
