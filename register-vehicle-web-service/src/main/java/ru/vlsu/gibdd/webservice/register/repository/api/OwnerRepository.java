package ru.vlsu.gibdd.webservice.register.repository.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.register.domain.Owner;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Repository
@CacheConfig(cacheNames = "owner")
public interface OwnerRepository extends JpaRepository<Owner, Long>, OwnerRepositoryCustom {

    @Override
    @CachePut
    Owner save(Owner owner);
}
