package ru.vlsu.gibdd.webservice.register.service.api;

import ru.vlsu.gibdd.webservice.register.io.FindRegistrationCertificateRequestIo;
import ru.vlsu.gibdd.webservice.register.io.FindRegistrationCertificateResponseIo;
import ru.vlsu.gibdd.webservice.register.io.RegisterVehicleRequestIo;
import ru.vlsu.gibdd.webservice.register.io.RegisterVehicleResponseIo;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
public interface RegistrationCertificateService {

    FindRegistrationCertificateResponseIo findRegistrationCertificate(FindRegistrationCertificateRequestIo request);
    RegisterVehicleResponseIo createRegistrationCertificate(RegisterVehicleRequestIo request);
}
