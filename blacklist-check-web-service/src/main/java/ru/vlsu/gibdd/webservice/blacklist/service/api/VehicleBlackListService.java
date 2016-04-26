package ru.vlsu.gibdd.webservice.blacklist.service.api;

import ru.vlsu.gibdd.webservice.blacklist.io.CheckResultIo;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
public interface VehicleBlackListService {

    CheckResultIo checkVehicle(VehiclePassIo vehiclePassIo);
}
