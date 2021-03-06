package ru.vlsu.gibdd.webservice.inspection.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.vlsu.gibdd.webservice.inspection.config.WebServiceConfig;
import ru.vlsu.gibdd.webservice.inspection.exception.CheckInspectionException;
import ru.vlsu.gibdd.webservice.inspection.io.AddInspectionRequestIo;
import ru.vlsu.gibdd.webservice.inspection.io.AddInspectionResponseIo;
import ru.vlsu.gibdd.webservice.inspection.io.CheckInspectionRequestIo;
import ru.vlsu.gibdd.webservice.inspection.io.CheckInspectionResponseIo;
import ru.vlsu.gibdd.webservice.inspection.service.api.InspectionService;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Endpoint
@Slf4j
public class InspectionEndpoint {

    @Autowired
    private InspectionService inspectionService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "AddInspectionRequest")
    @ResponsePayload
    public AddInspectionResponseIo handle(@RequestPayload AddInspectionRequestIo request) {
        log.info("Handle addInspection request: " + request);
        AddInspectionResponseIo response = inspectionService.addInspection(request);
        log.info("Send back addInspection response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "CheckInspectionRequest")
    @ResponsePayload
    public CheckInspectionResponseIo handle(@RequestPayload CheckInspectionRequestIo request) throws CheckInspectionException{
        log.info("Handle checkInspection request: " + request);
        CheckInspectionResponseIo response = inspectionService.checkInspection(request);
        log.info("Send back checkInspection response: " + response);
        return response;
    }
}
