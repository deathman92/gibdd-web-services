package ru.vlsu.gibdd.webservice.blacklist.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.blacklist.domain.CitizenBlackList;
import ru.vlsu.gibdd.webservice.common.domain.Passport;

import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Repository
public interface CitizenBlackListRepository extends JpaRepository<CitizenBlackList, Long> {

    @Query("from CitizenBlackList bl where bl.record.passport = ?1")
    List<CitizenBlackList> findAllByCitizenPassport(Passport passport);
}
