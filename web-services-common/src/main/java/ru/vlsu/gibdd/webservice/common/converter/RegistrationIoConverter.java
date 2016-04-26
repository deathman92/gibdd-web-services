package ru.vlsu.gibdd.webservice.common.converter;

import ru.vlsu.gibdd.webservice.common.domain.Registration;
import ru.vlsu.gibdd.webservice.common.annotation.IoConverter;
import ru.vlsu.gibdd.webservice.common.io.RegistrationIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@IoConverter
public class RegistrationIoConverter extends AbstractIoConverter<Registration, RegistrationIo> {

    @Override
    protected RegistrationIo convert(Registration source) {
        RegistrationIo target = new RegistrationIo();
        target.setRegion(source.getRegion());
        target.setDistrict(source.getDistrict());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setDate(source.getDate());
        return target;
    }

    @Override
    protected Registration convertBack(RegistrationIo source) {
        Registration target = new Registration();
        target.setRegion(source.getRegion());
        target.setDistrict(source.getDistrict());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        target.setDate(source.getDate());
        return target;
    }
}
