package ru.vlsu.gibdd.webservice.inspection.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
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
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class Inspection extends AbstractDomain {

    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate date;
    @Column(nullable = false)
    @Getter
    @Setter
    private String inspector;
    @ManyToOne(optional = false)
    @Getter
    @Setter
    private VehiclePass vehicle;
}
