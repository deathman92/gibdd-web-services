package ru.vlsu.gibdd.webservice.register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.repository.api.VehiclePassRepository;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;
import ru.vlsu.gibdd.webservice.common.service.impl.IoConverterServiceImpl;
import ru.vlsu.gibdd.webservice.register.domain.Owner;
import ru.vlsu.gibdd.webservice.register.domain.RegistrationCertificate;
import ru.vlsu.gibdd.webservice.register.io.*;
import ru.vlsu.gibdd.webservice.register.repository.api.OwnerRepository;
import ru.vlsu.gibdd.webservice.register.repository.api.RegistrationCertificateRepository;
import ru.vlsu.gibdd.webservice.register.service.api.RegistrationCertificateService;
import ru.vlsu.gibdd.webservice.register.service.api.RegistrationNumberService;

import java.time.LocalDate;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Service
public class RegistrationCertificateServiceImpl implements RegistrationCertificateService {

    @Autowired
    @Qualifier("ioConverterService")
    private ConverterService converterService;
    @Autowired
    private RegistrationCertificateRepository certificateRepository;
    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private VehiclePassRepository vehiclePassRepository;
    @Autowired
    private RegistrationNumberService numberService;


    @Override
    @Transactional(readOnly = true)
    public FindRegistrationCertificateResponseIo findRegistrationCertificate(FindRegistrationCertificateRequestIo request) {
        FindRegistrationCertificateResponseIo response = new FindRegistrationCertificateResponseIo();
        Owner owner = ownerRepository.findOwner(converterService.convert(request.getCitizen(), Owner.class));
        VehiclePass vehicle = vehiclePassRepository.findByVin(request.getVehiclePass().getVin());
        if (owner != null && vehicle != null) {
            RegistrationCertificate certificate = certificateRepository.findByOwnerAndVehicle(owner, vehicle);
            if (certificate != null) {
                response.setResult(true);
                response.setRegistrationCertificate(converterService.convert(certificate, RegistrationCertificateIo.class));
                return response;
            }
        }
        response.setResult(false);
        response.setRegistrationCertificate(null);
        return response;
    }

    @Override
    @Transactional
    public RegisterVehicleResponseIo createRegistrationCertificate(RegisterVehicleRequestIo request) {
        RegisterVehicleResponseIo response = new RegisterVehicleResponseIo();
        Owner owner = converterService.convert(request.getCitizen(), Owner.class);
        ownerRepository.save(owner);
        VehiclePass vehicle = converterService.convert(request.getVehiclePass(), VehiclePass.class);
        vehiclePassRepository.save(vehicle);
        RegistrationCertificate certificate = new RegistrationCertificate();
        certificate.setOwner(owner);
        certificate.setVehicle(vehicle);
        certificate.setIssueDate(LocalDate.now());
        certificate.setIssuePlace("Управление ГИБДД УМВД России по Владимирской области");
        certificate.setRegistrationNumber(numberService.getNumber());
        certificateRepository.save(certificate);
        response.setRegistrationCertificate(converterService.convert(certificate, RegistrationCertificateIo.class));
        return response;
    }
}
