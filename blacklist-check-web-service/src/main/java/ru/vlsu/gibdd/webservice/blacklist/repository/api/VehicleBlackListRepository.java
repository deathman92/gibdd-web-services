package ru.vlsu.gibdd.webservice.blacklist.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.blacklist.domain.VehicleBlackList;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;

import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Repository
public interface VehicleBlackListRepository extends JpaRepository<VehicleBlackList, Long> {

    @Query("from VehicleBlackList bl where bl.record = ?1")
    List<VehicleBlackList> findAllByVehicle(VehiclePass vehiclePass);
}
