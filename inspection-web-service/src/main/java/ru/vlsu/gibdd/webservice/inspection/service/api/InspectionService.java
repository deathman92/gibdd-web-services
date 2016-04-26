package ru.vlsu.gibdd.webservice.inspection.service.api;

import ru.vlsu.gibdd.webservice.inspection.exception.CheckInspectionException;
import ru.vlsu.gibdd.webservice.inspection.io.AddInspectionRequestIo;
import ru.vlsu.gibdd.webservice.inspection.io.AddInspectionResponseIo;
import ru.vlsu.gibdd.webservice.inspection.io.CheckInspectionRequestIo;
import ru.vlsu.gibdd.webservice.inspection.io.CheckInspectionResponseIo;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
public interface InspectionService {

    AddInspectionResponseIo addInspection(AddInspectionRequestIo request);
    CheckInspectionResponseIo checkInspection(CheckInspectionRequestIo request) throws CheckInspectionException;
}
