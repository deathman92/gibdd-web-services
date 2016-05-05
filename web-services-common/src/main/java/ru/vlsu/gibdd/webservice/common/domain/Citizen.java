package ru.vlsu.gibdd.webservice.common.domain;

import lombok.*;
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
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class Citizen extends AbstractDomain {

    @Column(nullable = false)
    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private String middlename;
    @Column(nullable = false)
    @Getter
    @Setter
    private String lastname;
    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate birthday;
    @Column(nullable = false)
    @Getter
    @Setter
    private String birthPlace;
    @Convert(converter = GenderTypeConverter.class)
    @Column(nullable = false)
    @Getter
    @Setter
    private Gender gender;
    @Embedded
    @Getter
    @Setter
    private Passport passport;

    @RequiredArgsConstructor
    public enum Gender {
        MALE("male"),
        FEMALE("female"),
        OTHER("other");

        @Getter
        private final String value;

        public static Gender fromValue(String value) {
            for (Gender gender : Gender.values()) {
                if (gender.value.equals(value)) {
                    return gender;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
