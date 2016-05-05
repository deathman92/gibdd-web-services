package ru.vlsu.gibdd.webservice.common.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Embeddable
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
public class Registration {

    @Column(nullable = false)
    @Getter
    @Setter
    private String region;
    @Getter
    @Setter
    private String district;
    @Column(nullable = false)
    @Getter
    @Setter
    private String city;
    @Column(nullable = false)
    @Getter
    @Setter
    private String address;
    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate date;
}
