package ru.vlsu.gibdd.webservice.register.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Entity
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class Owner extends AbstractDomain {

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
}
