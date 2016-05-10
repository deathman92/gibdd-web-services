package ru.vlsu.gibdd.webservice.common.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.io.CategoryIo;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Component
@Qualifier("ioConverter")
public class VehiclePassIoConverter extends AbstractIoConverter<VehiclePass, VehiclePassIo> {

    @Override
    protected VehiclePassIo convert(VehiclePass source, VehiclePassIo target) {
        target.setVin(source.getVin());
        target.setModel(source.getModel());
        target.setType(source.getType());
        if (source.getCategory() != null) {
            target.setCategory(CategoryIo.fromValue(source.getCategory().name()));
        }
        target.setBuiltYear(source.getBuiltYear());
        target.setEngineNumber(source.getEngineNumber());
        target.setChassisNumber(source.getChassisNumber());
        target.setBodyNumber(source.getBodyNumber());
        target.setBodyColor(source.getBodyColor());
        return target;
    }

    @Override
    protected VehiclePass convertBack(VehiclePassIo source, VehiclePass target) {
        target.setVin(source.getVin());
        target.setModel(source.getModel());
        target.setType(source.getType());
        if (source.getCategory() != null) {
            target.setCategory(VehiclePass.Category.valueOf(source.getCategory().name()));
        }
        target.setBuiltYear(source.getBuiltYear());
        target.setEngineNumber(source.getEngineNumber());
        target.setChassisNumber(source.getChassisNumber());
        target.setBodyNumber(source.getBodyNumber());
        target.setBodyColor(source.getBodyColor());
        return target;
    }
}
