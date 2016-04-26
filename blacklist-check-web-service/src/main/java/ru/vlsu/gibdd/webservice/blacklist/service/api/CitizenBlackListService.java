package ru.vlsu.gibdd.webservice.blacklist.service.api;

import ru.vlsu.gibdd.webservice.blacklist.io.CheckResultIo;
import ru.vlsu.gibdd.webservice.common.io.CitizenIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
public interface CitizenBlackListService {

    CheckResultIo checkCitizen(CitizenIo citizenIo);
}
