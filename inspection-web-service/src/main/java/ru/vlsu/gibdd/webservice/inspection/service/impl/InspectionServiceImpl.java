package ru.vlsu.gibdd.webservice.inspection.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;
import ru.vlsu.gibdd.webservice.common.repository.api.VehiclePassRepository;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;
import ru.vlsu.gibdd.webservice.inspection.domain.Inspection;
import ru.vlsu.gibdd.webservice.inspection.exception.CheckInspectionException;
import ru.vlsu.gibdd.webservice.inspection.io.*;
import ru.vlsu.gibdd.webservice.inspection.repository.api.InspectionRepository;
import ru.vlsu.gibdd.webservice.inspection.service.api.InspectionService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Service
public class InspectionServiceImpl implements InspectionService {

    @Autowired
    private InspectionRepository inspectionRepository;
    @Autowired
    private VehiclePassRepository vehiclePassRepository;
    @Autowired
    private ConverterService ioConverterService;

    @Override
    @Transactional
    public AddInspectionResponseIo addInspection(AddInspectionRequestIo request) {
        List<VehiclePass> vehicles = ioConverterService.convertList(request.getVehiclePassList(), VehiclePass.class);
        List<Inspection> inspections = new ArrayList<>();
        for (VehiclePass vehicle: vehicles) {
            VehiclePass foundVehicle = vehiclePassRepository.findByVin(vehicle.getVin());
            if (foundVehicle == null) {
                foundVehicle = vehiclePassRepository.save(vehicle);
            }
            Inspection inspection = new Inspection();
            inspection.setDate(request.getDate());
            inspection.setInspector(request.getInspector());
            inspection.setVehicle(foundVehicle);
            inspectionRepository.save(inspection);
            inspections.add(inspection);
        }
        AddInspectionResponseIo response = new AddInspectionResponseIo();
        response.getInspectionList().addAll(ioConverterService.convertList(inspections, InspectionIo.class));
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public CheckInspectionResponseIo checkInspection(CheckInspectionRequestIo request) throws CheckInspectionException {
        VehiclePass vehicle = ioConverterService.convert(request.getVehicle(), VehiclePass.class);
        Inspection inspection = inspectionRepository.findFirstByVehicleVinOrderByDateDesc(vehicle.getVin());
        if (inspection == null) {
            throw new CheckInspectionException("Карта осмотра ТС " + vehicle.getVin() + " не найдена.");
        }
        VehiclePass foundVehicle = inspection.getVehicle();
        boolean result = true;
        if (!vehicle.getType().equals(foundVehicle.getType())) {
            result = false;
        }
        if (!vehicle.getCategory().equals(foundVehicle.getCategory())) {
            result = false;
        }
        if (!vehicle.getModel().equals(foundVehicle.getModel())) {
            result = false;
        }
        if (!vehicle.getBuiltYear().equals(foundVehicle.getBuiltYear())) {
            result = false;
        }
        if (!vehicle.getEngineNumber().equals(foundVehicle.getEngineNumber())) {
            result = false;
        }
        if (!vehicle.getChassisNumber().equals(foundVehicle.getChassisNumber())) {
            result = false;
        }
        if (!vehicle.getBodyNumber().equals(foundVehicle.getBodyNumber())) {
            result = false;
        }
        if (!vehicle.getBodyColor().equals(foundVehicle.getBodyColor())) {
            result = false;
        }
        CheckInspectionResponseIo response = new CheckInspectionResponseIo();
        response.setResult(result);
        response.setVehicle(ioConverterService.convert(foundVehicle, VehiclePassIo.class));
        return response;
    }
}
