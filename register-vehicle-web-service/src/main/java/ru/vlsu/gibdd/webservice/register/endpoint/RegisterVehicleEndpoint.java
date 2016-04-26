package ru.vlsu.gibdd.webservice.register.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.vlsu.gibdd.webservice.register.config.WebServiceConfig;
import ru.vlsu.gibdd.webservice.register.io.FindRegistrationCertificateRequestIo;
import ru.vlsu.gibdd.webservice.register.io.FindRegistrationCertificateResponseIo;
import ru.vlsu.gibdd.webservice.register.io.RegisterVehicleRequestIo;
import ru.vlsu.gibdd.webservice.register.io.RegisterVehicleResponseIo;
import ru.vlsu.gibdd.webservice.register.service.api.RegistrationCertificateService;
import ru.vlsu.gibdd.webservice.register.service.impl.RegistrationCertificateServiceImpl;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Endpoint
public class RegisterVehicleEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(RegisterVehicleEndpoint.class);

    @Autowired
    private RegistrationCertificateService certificateService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "RegisterVehicleRequest")
    @ResponsePayload
    public RegisterVehicleResponseIo handle(@RequestPayload RegisterVehicleRequestIo request) {
        logger.info("Handle registerVehicle request: " + request);
        RegisterVehicleResponseIo response = certificateService.createRegistrationCertificate(request);
        logger.info("Send back registerVehicle response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "FindRegistrationCertificateRequest")
    @ResponsePayload
    public FindRegistrationCertificateResponseIo handle(@RequestPayload FindRegistrationCertificateRequestIo request) {
        logger.info("Handle findRegistrationCertificate request: " + request);
        FindRegistrationCertificateResponseIo response = certificateService.findRegistrationCertificate(request);
        logger.info("Send back findRegistrationCertificate response: " + response);
        return response;
    }
}
