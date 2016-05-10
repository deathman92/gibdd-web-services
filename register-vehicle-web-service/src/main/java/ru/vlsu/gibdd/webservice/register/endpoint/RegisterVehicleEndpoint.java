package ru.vlsu.gibdd.webservice.register.endpoint;

import lombok.extern.slf4j.Slf4j;
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

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Endpoint
@Slf4j
public class RegisterVehicleEndpoint {

    @Autowired
    private RegistrationCertificateService certificateService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "RegisterVehicleRequest")
    @ResponsePayload
    public RegisterVehicleResponseIo handle(@RequestPayload RegisterVehicleRequestIo request) {
        log.info("Handle registerVehicle request: " + request);
        RegisterVehicleResponseIo response = certificateService.createRegistrationCertificate(request);
        log.info("Send back registerVehicle response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "FindRegistrationCertificateRequest")
    @ResponsePayload
    public FindRegistrationCertificateResponseIo handle(@RequestPayload FindRegistrationCertificateRequestIo request) {
        log.info("Handle findRegistrationCertificate request: " + request);
        FindRegistrationCertificateResponseIo response = certificateService.findRegistrationCertificate(request);
        log.info("Send back findRegistrationCertificate response: " + response);
        return response;
    }
}
