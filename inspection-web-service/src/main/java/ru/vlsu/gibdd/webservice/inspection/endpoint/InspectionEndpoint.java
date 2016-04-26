package ru.vlsu.gibdd.webservice.inspection.endpoint;

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
public class InspectionEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(InspectionEndpoint.class);

    @Autowired
    private InspectionService inspectionService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "AddInspectionRequest")
    @ResponsePayload
    public AddInspectionResponseIo handle(@RequestPayload AddInspectionRequestIo request) {
        logger.info("Handle addInspection request: " + request);
        AddInspectionResponseIo response = inspectionService.addInspection(request);
        logger.info("Send back addInspection response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "CheckInspectionRequest")
    @ResponsePayload
    public CheckInspectionResponseIo handle(@RequestPayload CheckInspectionRequestIo request) throws CheckInspectionException{
        logger.info("Handle checkInspection request: " + request);
        CheckInspectionResponseIo response = inspectionService.checkInspection(request);
        logger.info("Send back checkInspection response: " + response);
        return response;
    }
}
