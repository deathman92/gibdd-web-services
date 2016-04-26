package ru.vlsu.gibdd.webservice.common.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import ru.vlsu.gibdd.webservice.common.converter.GenderTypeConverter;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(columnNames = {"series", "number"}))
public class Citizen extends AbstractDomain {

    @Column(nullable = false)
    private String firstname;
    private String middlename;
    @Column(nullable = false)
    private String lastname;
    @Column(nullable = false)
    private LocalDate birthday;
    @Column(nullable = false)
    private String birthPlace;
    @Convert(converter = GenderTypeConverter.class)
    @Column(nullable = false)
    private Gender gender;
    @Embedded
    private Passport passport;

    public enum Gender {
        MALE("male"),
        FEMALE("female"),
        OTHER("other");

        private final String value;

        Gender(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

        public static Gender fromValue(String value) {
            for (Gender gender : Gender.values()) {
                if (gender.value.equals(value)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    // region Getter and Setters
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
    // endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equal(firstname, citizen.firstname) &&
                Objects.equal(middlename, citizen.middlename) &&
                Objects.equal(lastname, citizen.lastname) &&
                Objects.equal(birthday, citizen.birthday) &&
                Objects.equal(birthPlace, citizen.birthPlace) &&
                gender == citizen.gender &&
                Objects.equal(passport, citizen.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), firstname, middlename, lastname, birthday, birthPlace, gender, passport);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("firstname", firstname)
                .add("middlename", middlename)
                .add("lastname", lastname)
                .add("birthday", birthday)
                .add("birthPlace", birthPlace)
                .add("gender", gender)
                .add("passport", passport)
                .toString();
    }
}
