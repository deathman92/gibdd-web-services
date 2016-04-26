package ru.vlsu.gibdd.webservice.register.converter;

import ru.vlsu.gibdd.webservice.common.annotation.IoConverter;
import ru.vlsu.gibdd.webservice.common.converter.AbstractIoConverter;
import ru.vlsu.gibdd.webservice.register.domain.Owner;
import ru.vlsu.gibdd.webservice.register.io.OwnerIo;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@IoConverter
public class OwnerIoConverter extends AbstractIoConverter<Owner, OwnerIo> {

    @Override
    protected OwnerIo convert(Owner source) {
        OwnerIo target = new OwnerIo();
        target.setFirstname(source.getFirstname());
        target.setMiddlename(source.getMiddlename());
        target.setLastname(source.getLastname());
        target.setRegion(source.getRegion());
        target.setDistrict(source.getDistrict());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        return target;
    }

    @Override
    protected Owner convertBack(OwnerIo source) {
        Owner target = new Owner();
        target.setFirstname(source.getFirstname());
        target.setMiddlename(source.getMiddlename());
        target.setLastname(source.getLastname());
        target.setRegion(source.getRegion());
        target.setDistrict(source.getDistrict());
        target.setCity(source.getCity());
        target.setAddress(source.getAddress());
        return target;
    }
}
