package ru.vlsu.gibdd.webservice.common.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.common.domain.Citizen;
import ru.vlsu.gibdd.webservice.common.domain.Passport;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Citizen findByPassport(Passport passport);
}
