package ru.vlsu.gibdd.webservice.common.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vlsu.gibdd.webservice.common.domain.Registration;
import ru.vlsu.gibdd.webservice.common.io.RegistrationIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@SuppressWarnings("Duplicates")
@Component
@Qualifier("ioConverter")
public class RegistrationIoConverter extends AbstractIoConverter<Registration, RegistrationIo> {

    @Override
    protected RegistrationIo convert(Registration source, RegistrationIo target) {
        target.setRegion(source.getRegion());
        target.setDistrict(source.getDistrict());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setDate(source.getDate());
        return target;
    }

    @Override
    protected Registration convertBack(RegistrationIo source, Registration target) {
        target.setRegion(source.getRegion());
        target.setDistrict(source.getDistrict());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setDate(source.getDate());
        return target;
    }
}
