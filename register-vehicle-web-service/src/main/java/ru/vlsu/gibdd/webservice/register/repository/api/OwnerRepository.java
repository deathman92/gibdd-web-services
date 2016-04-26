package ru.vlsu.gibdd.webservice.register.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.register.domain.Owner;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>, OwnerRepositoryCustom {
}
