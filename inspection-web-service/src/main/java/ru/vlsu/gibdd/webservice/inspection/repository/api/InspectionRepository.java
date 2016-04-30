package ru.vlsu.gibdd.webservice.inspection.repository.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.inspection.domain.Inspection;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Repository
@CacheConfig(cacheNames = "inspection")
public interface InspectionRepository extends JpaRepository<Inspection, Long> {

    @Cacheable
    Inspection findFirstByVehicleVinOrderByDateDesc(String vin);
}
