package ru.vlsu.gibdd.webservice.blacklist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@MappedSuperclass
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public abstract class AbstractBlackList<T extends AbstractDomain> extends AbstractDomain {

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @Getter
    @Setter
    protected T record;
    @Getter
    @Setter
    @Column(nullable = false)
    protected String statusMessage;
}
