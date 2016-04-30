package ru.vlsu.gibdd.webservice.common.repository.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Repository
@CacheConfig(cacheNames = "vehicle")
public interface VehiclePassRepository extends JpaRepository<VehiclePass, Long> {

    @Cacheable
    VehiclePass findByVin(String vin);
}
