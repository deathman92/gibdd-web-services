package ru.vlsu.gibdd.webservice.blacklist.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
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
public abstract class AbstractBlackList<T extends AbstractDomain> extends AbstractDomain {

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    protected T record;
    @Column(nullable = false)
    protected String statusMessage;

    // region Getters and Setters
    public T getRecord() {
        return record;
    }

    public void setRecord(T record) {
        this.record = record;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    // endregion

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractBlackList<?> that = (AbstractBlackList<?>) o;
        return Objects.equal(record, that.record) &&
                Objects.equal(statusMessage, that.statusMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(super.hashCode(), record, statusMessage);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("record", record)
                .add("statusMessage", statusMessage)
                .toString();
    }
}
