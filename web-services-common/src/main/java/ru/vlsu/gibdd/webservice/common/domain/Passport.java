package ru.vlsu.gibdd.webservice.common.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Embeddable
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
public class Passport {

    @Column(nullable = false)
    @Getter
    @Setter
    private String series;
    @Column(nullable = false)
    @Getter
    @Setter
    private String number;
    @Column(nullable = false)
    @Getter
    @Setter
    private LocalDate issueDate;
    @Column(nullable = false)
    @Getter
    @Setter
    private String issuedBy;
    @Embedded
    @Getter
    @Setter
    private Registration registration;
}
