package ru.vlsu.gibdd.webservice.register.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.vlsu.gibdd.webservice.common.io.CitizenIo;
import ru.vlsu.gibdd.webservice.register.domain.Owner;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Component
@Qualifier("ioConverter")
public class CitizenIoToOwnerConverter implements Converter<CitizenIo, Owner> {

    @Override
    public Owner convert(CitizenIo source) {
        Owner target = new Owner();
        target.setFirstname(source.getFirstname());
        target.setMiddlename(source.getMiddlename());
        target.setLastname(source.getLastname());
        target.setRegion(source.getPassport().getRegistration().getRegion());
        target.setDistrict(source.getPassport().getRegistration().getDistrict());
        target.setCity(source.getPassport().getRegistration().getCity());
        target.setAddress(source.getPassport().getRegistration().getAddress());
        return target;
    }
}
