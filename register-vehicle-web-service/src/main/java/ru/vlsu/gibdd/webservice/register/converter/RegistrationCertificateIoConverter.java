package ru.vlsu.gibdd.webservice.register.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vlsu.gibdd.webservice.common.converter.AbstractIoConverter;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;
import ru.vlsu.gibdd.webservice.register.domain.Owner;
import ru.vlsu.gibdd.webservice.register.domain.RegistrationCertificate;
import ru.vlsu.gibdd.webservice.register.io.OwnerIo;
import ru.vlsu.gibdd.webservice.register.io.RegistrationCertificateIo;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Component
@Qualifier("ioConverter")
public class RegistrationCertificateIoConverter extends AbstractIoConverter<RegistrationCertificate, RegistrationCertificateIo> {

    @Override
    protected RegistrationCertificateIo convert(RegistrationCertificate source, RegistrationCertificateIo target) {
        target.setRegistrationNumber(source.getRegistrationNumber());
        target.setIssuePlace(source.getIssuePlace());
        target.setIssueDate(source.getIssueDate());
        target.setVehicle(getConverterService().convert(source.getVehicle(), VehiclePassIo.class));
        target.setOwner(getConverterService().convert(source.getOwner(), OwnerIo.class));
        return target;
    }

    @Override
    protected RegistrationCertificate convertBack(RegistrationCertificateIo source, RegistrationCertificate target) {
        target.setRegistrationNumber(source.getRegistrationNumber());
        target.setIssuePlace(source.getIssuePlace());
        target.setIssueDate(source.getIssueDate());
        target.setVehicle(getConverterService().convert(source.getVehicle(), VehiclePass.class));
        target.setOwner(getConverterService().convert(source.getOwner(), Owner.class));
        return target;
    }
}
