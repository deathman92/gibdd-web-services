package ru.vlsu.gibdd.webservice.inspection.exception;

import ru.vlsu.gibdd.webservice.inspection.io.CheckInspectionFaultIo;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
public class CheckInspectionException extends Exception {

    private CheckInspectionFaultIo fault;

    public CheckInspectionException(String message) {
        super(message);
        CheckInspectionFaultIo fault = new CheckInspectionFaultIo();
        fault.setMessage(message);
        this.fault = fault;
    }

    public CheckInspectionFaultIo getFault() {
        return fault;
    }
}
