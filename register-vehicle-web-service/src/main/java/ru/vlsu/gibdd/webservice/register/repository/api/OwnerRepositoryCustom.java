package ru.vlsu.gibdd.webservice.register.repository.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import ru.vlsu.gibdd.webservice.register.domain.Owner;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@CacheConfig(cacheNames = "owner")
public interface OwnerRepositoryCustom {

    @Cacheable
    Owner findOwner(Owner owner);
}
