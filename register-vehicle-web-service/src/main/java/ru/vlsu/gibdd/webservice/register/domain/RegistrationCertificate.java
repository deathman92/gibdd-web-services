package ru.vlsu.gibdd.webservice.register.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class RegistrationCertificate extends AbstractDomain {

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String registrationNumber;
    @Column(nullable = false)
    @Getter
    @Setter
    private String issuePlace;
    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate issueDate;
    @OneToOne(optional = false)
    @Getter
    @Setter
    private VehiclePass vehicle;
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private Owner owner;
}
