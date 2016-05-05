package ru.vlsu.gibdd.webservice.signature.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(callSuper = true, doNotUseGetters = true)
@ToString(callSuper = true, doNotUseGetters = true)
public class Signature extends AbstractDomain {

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String value;
    @CreatedDate
    @Getter
    @Setter
    private LocalDate createdDate;
}
