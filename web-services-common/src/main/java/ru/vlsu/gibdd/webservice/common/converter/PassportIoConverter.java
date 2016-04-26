package ru.vlsu.gibdd.webservice.common.converter;

import ru.vlsu.gibdd.webservice.common.domain.Passport;
import ru.vlsu.gibdd.webservice.common.domain.Registration;
import ru.vlsu.gibdd.webservice.common.annotation.IoConverter;
import ru.vlsu.gibdd.webservice.common.io.PassportIo;
import ru.vlsu.gibdd.webservice.common.io.RegistrationIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@IoConverter
public class PassportIoConverter extends AbstractIoConverter<Passport, PassportIo> {

    @Override
    protected PassportIo convert(Passport source) {
        PassportIo target = new PassportIo();
        target.setSeries(source.getSeries());
        target.setNumber(source.getNumber());
        target.setIssueDate(source.getIssueDate());
        target.setIssuedBy(source.getIssuedBy());
        target.setRegistration(getConverterService().convert(source.getRegistration(), RegistrationIo.class));
        return target;
    }

    @Override
    protected Passport convertBack(PassportIo source) {
        Passport target = new Passport();
        target.setSeries(source.getSeries());
        target.setNumber(source.getNumber());
        target.setIssueDate(source.getIssueDate());
        target.setIssuedBy(source.getIssuedBy());
        target.setRegistration(getConverterService().convert(source.getRegistration(), Registration.class));
        return target;
    }
}
