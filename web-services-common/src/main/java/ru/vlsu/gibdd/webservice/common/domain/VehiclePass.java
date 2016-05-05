package ru.vlsu.gibdd.webservice.common.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.TypeDef;
import ru.vlsu.gibdd.webservice.common.type.YearType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Year;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Entity
@TypeDef(defaultForType = Year.class, typeClass = YearType.class)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class VehiclePass extends AbstractDomain {

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String vin;
    @Column(nullable = false)
    @Getter
    @Setter
    private String model;
    @Column(nullable = false)
    @Getter
    @Setter
    private String type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Category category;
    @Column(nullable = false)
    @Getter
    @Setter
    private Year builtYear;
    @Column(nullable = false)
    @Getter
    @Setter
    private String engineNumber;
    @Column(nullable = false)
    @Getter
    @Setter
    private String chassisNumber;
    @Getter
    @Setter
    private String bodyNumber;
    @Column(nullable = false)
    @Getter
    @Setter
    private String bodyColor;

    public enum Category {
        A, B, C, D
    }
}
