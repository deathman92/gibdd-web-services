package ru.vlsu.gibdd.webservice.blacklist.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.vlsu.gibdd.webservice.blacklist.config.WebServiceConfig;
import ru.vlsu.gibdd.webservice.blacklist.io.*;
import ru.vlsu.gibdd.webservice.blacklist.service.api.CitizenBlackListService;
import ru.vlsu.gibdd.webservice.blacklist.service.api.VehicleBlackListService;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Endpoint
public class BlackListCheckEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(BlackListCheckEndpoint.class);

    @Autowired
    private CitizenBlackListService citizenBlackListService;
    @Autowired
    private VehicleBlackListService vehicleBlackListService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "CheckCitizenRequest")
    @ResponsePayload
    public CheckCitizenResponseIo handle(@RequestPayload CheckCitizenRequestIo request) {
        logger.info("Handle checkCitizen request: " + request);
        CheckResultIo result = citizenBlackListService.checkCitizen(request.getCitizen());
        CheckCitizenResponseIo response = new CheckCitizenResponseIo();
        response.setResult(result);
        logger.info("Send back checkCitizen response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "CheckVehicleRequest")
    @ResponsePayload
    public CheckVehicleResponseIo handle(@RequestPayload CheckVehicleRequestIo request) {
        logger.info("Handle checkVehicle request: " + request);
        CheckResultIo result = vehicleBlackListService.checkVehicle(request.getVehiclePass());
        CheckVehicleResponseIo response = new CheckVehicleResponseIo();
        response.setResult(result);
        logger.info("Send back checkVehicle response: " + response);
        return response;
    }
}
