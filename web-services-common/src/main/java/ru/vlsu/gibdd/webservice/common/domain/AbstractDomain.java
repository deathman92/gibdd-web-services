package ru.vlsu.gibdd.webservice.common.domain;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@MappedSuperclass
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
@NoArgsConstructor
public abstract class AbstractDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    protected Long id;
}
