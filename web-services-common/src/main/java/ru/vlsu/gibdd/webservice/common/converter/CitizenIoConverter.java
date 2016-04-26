package ru.vlsu.gibdd.webservice.common.converter;

import ru.vlsu.gibdd.webservice.common.domain.Citizen;
import ru.vlsu.gibdd.webservice.common.domain.Passport;
import ru.vlsu.gibdd.webservice.common.annotation.IoConverter;
import ru.vlsu.gibdd.webservice.common.io.CitizenIo;
import ru.vlsu.gibdd.webservice.common.io.GenderIo;
import ru.vlsu.gibdd.webservice.common.io.PassportIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@IoConverter
public class CitizenIoConverter extends AbstractIoConverter<Citizen, CitizenIo> {

    @Override
    protected CitizenIo convert(Citizen source) {
        CitizenIo target = new CitizenIo();
        target.setFirstname(source.getFirstname());
        target.setMiddlename(source.getMiddlename());
        target.setLastname(source.getLastname());
        target.setBirthday(source.getBirthday());
        target.setBirthPlace(source.getBirthPlace());
        if (source.getGender() != null) {
            target.setGender(GenderIo.fromValue(source.getGender().value()));
        }
        target.setPassport(getConverterService().convert(source.getPassport(), PassportIo.class));
        return target;
    }

    @Override
    protected Citizen convertBack(CitizenIo source) {
        Citizen target = new Citizen();
        target.setFirstname(source.getFirstname());
        target.setMiddlename(source.getMiddlename());
        target.setLastname(source.getLastname());
        target.setBirthday(source.getBirthday());
        target.setBirthPlace(source.getBirthPlace());
        if (source.getGender() != null) {
            target.setGender(Citizen.Gender.fromValue(source.getGender().value()));
        }
        target.setPassport(getConverterService().convert(source.getPassport(), Passport.class));
        return target;
    }
}
