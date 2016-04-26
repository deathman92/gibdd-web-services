package ru.vlsu.gibdd.webservice.signature.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
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
public class Signature extends AbstractDomain {

    @Column(nullable = false, unique = true)
    private String value;
    @CreatedDate
    private LocalDate createdDate;

    //region Getters and Setters
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
    //endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Signature signature = (Signature) o;
        return Objects.equal(value, signature.value) &&
                Objects.equal(createdDate, signature.createdDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), value, createdDate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("value", value)
                .add("createdDate", createdDate)
                .toString();
    }
}
