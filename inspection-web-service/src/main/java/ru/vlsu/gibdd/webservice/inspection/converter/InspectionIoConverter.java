package ru.vlsu.gibdd.webservice.inspection.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vlsu.gibdd.webservice.common.converter.AbstractIoConverter;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;
import ru.vlsu.gibdd.webservice.inspection.domain.Inspection;
import ru.vlsu.gibdd.webservice.inspection.io.InspectionIo;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Component
@Qualifier("ioConverter")
public class InspectionIoConverter extends AbstractIoConverter<Inspection, InspectionIo> {

    @Override
    protected InspectionIo convert(Inspection source, InspectionIo target) {
        target.setDate(source.getDate());
        target.setInspector(source.getInspector());
        target.setVehicle(getConverterService().convert(source.getVehicle(), VehiclePassIo.class));
        return target;
    }

    @Override
    protected Inspection convertBack(InspectionIo source, Inspection target) {
        target.setDate(source.getDate());
        target.setInspector(source.getInspector());
        target.setVehicle(getConverterService().convert(source.getVehicle(), VehiclePass.class));
        return target;
    }
}
