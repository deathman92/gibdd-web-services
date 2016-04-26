package ru.vlsu.gibdd.webservice.register.repository.api;

import ru.vlsu.gibdd.webservice.register.domain.Owner;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
public interface OwnerRepositoryCustom {

    Owner findOwner(Owner owner);
}
