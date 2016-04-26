package ru.vlsu.gibdd.webservice.inspection.converter;

import ru.vlsu.gibdd.webservice.common.annotation.IoConverter;
import ru.vlsu.gibdd.webservice.common.converter.AbstractIoConverter;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;
import ru.vlsu.gibdd.webservice.inspection.domain.Inspection;
import ru.vlsu.gibdd.webservice.inspection.io.InspectionIo;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@IoConverter
public class InspectionIoConverter extends AbstractIoConverter<Inspection, InspectionIo> {

    @Override
    protected InspectionIo convert(Inspection source) {
        InspectionIo target = new InspectionIo();
        target.setDate(source.getDate());
        target.setInspector(source.getInspector());
        target.setVehicle(getConverterService().convert(source.getVehicle(), VehiclePassIo.class));
        return target;
    }

    @Override
    protected Inspection convertBack(InspectionIo source) {
        Inspection target = new Inspection();
        target.setDate(source.getDate());
        target.setInspector(source.getInspector());
        target.setVehicle(getConverterService().convert(source.getVehicle(), VehiclePass.class));
        return target;
    }
}
