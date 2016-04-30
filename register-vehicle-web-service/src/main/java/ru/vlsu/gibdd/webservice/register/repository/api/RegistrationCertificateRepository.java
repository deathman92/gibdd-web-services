package ru.vlsu.gibdd.webservice.register.repository.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.register.domain.Owner;
import ru.vlsu.gibdd.webservice.register.domain.RegistrationCertificate;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Repository
@CacheConfig(cacheNames = "certificate")
public interface RegistrationCertificateRepository extends JpaRepository<RegistrationCertificate, Long> {

    @Cacheable
    RegistrationCertificate findByOwnerAndVehicle(Owner owner, VehiclePass vehicle);
}
