package ru.vlsu.gibdd.webservice.register;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.soap.SoapBody;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.test.server.ResponseMatcher;
import ru.vlsu.gibdd.webservice.common.io.CategoryIo;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;
import ru.vlsu.gibdd.webservice.common.test.AbstractEndpointTest;
import ru.vlsu.gibdd.webservice.inspection.Application;
import ru.vlsu.gibdd.webservice.inspection.io.*;

import javax.xml.bind.util.JAXBSource;
import javax.xml.namespace.QName;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

/**
 * @author Victor Zhivotikov
 * @since 10.05.2016
 */
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("unittest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InspectionEndpointTest extends AbstractEndpointTest {

    @Test
    public void addInspectionTest() throws Exception {
        AddInspectionRequestIo request = new AddInspectionRequestIo();
        request.setDate(LocalDate.now());
        request.setInspector("Inspector");
        VehiclePassIo vehiclePass = new VehiclePassIo();
        vehiclePass.setVin("1234567890ABCDEFG");
        vehiclePass.setModel("Lada");
        vehiclePass.setType("Sedan");
        vehiclePass.setCategory(CategoryIo.B);
        vehiclePass.setBuiltYear(Year.of(1980));
        vehiclePass.setEngineNumber("ABC123");
        vehiclePass.setChassisNumber("ABC123");
        vehiclePass.setBodyNumber("ABC123");
        vehiclePass.setBodyColor("eggplant");
        request.getVehiclePassList().add(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        AddInspectionResponseIo response = new AddInspectionResponseIo();
        InspectionIo inspection = new InspectionIo();
        inspection.setDate(LocalDate.now());
        inspection.setInspector("Inspector");
        inspection.setVehicle(vehiclePass);
        response.getInspectionList().add(inspection);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void checkInspectionSuccessTest() throws Exception {
        CheckInspectionRequestIo request = new CheckInspectionRequestIo();
        VehiclePassIo vehiclePass = new VehiclePassIo();
        vehiclePass.setVin("1234567890ABCDEFG");
        vehiclePass.setModel("Lada");
        vehiclePass.setType("Sedan");
        vehiclePass.setCategory(CategoryIo.B);
        vehiclePass.setBuiltYear(Year.of(1980));
        vehiclePass.setEngineNumber("ABC123");
        vehiclePass.setChassisNumber("ABC123");
        vehiclePass.setBodyNumber("ABC123");
        vehiclePass.setBodyColor("eggplant");
        request.setVehicle(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        CheckInspectionResponseIo response = new CheckInspectionResponseIo();
        response.setResult(true);
        response.setVehicle(vehiclePass);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void checkInspectionFailTest() throws Exception {
        CheckInspectionRequestIo request = new CheckInspectionRequestIo();
        VehiclePassIo vehiclePass = new VehiclePassIo();
        vehiclePass.setVin("1234567890ABCDEFG");
        vehiclePass.setModel("Lada1");
        vehiclePass.setType("Sedan1");
        vehiclePass.setCategory(CategoryIo.A);
        vehiclePass.setBuiltYear(Year.of(1981));
        vehiclePass.setEngineNumber("ABC1231");
        vehiclePass.setChassisNumber("ABC1231");
        vehiclePass.setBodyNumber("ABC1231");
        vehiclePass.setBodyColor("eggplant1");
        request.setVehicle(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        CheckInspectionResponseIo response = new CheckInspectionResponseIo();
        VehiclePassIo foundVehiclePass = new VehiclePassIo();
        foundVehiclePass.setVin("1234567890ABCDEFG");
        foundVehiclePass.setModel("Lada");
        foundVehiclePass.setType("Sedan");
        foundVehiclePass.setCategory(CategoryIo.B);
        foundVehiclePass.setBuiltYear(Year.of(1980));
        foundVehiclePass.setEngineNumber("ABC123");
        foundVehiclePass.setChassisNumber("ABC123");
        foundVehiclePass.setBodyNumber("ABC123");
        foundVehiclePass.setBodyColor("eggplant");
        response.setResult(false);
        response.setVehicle(foundVehiclePass);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void checkInspectionFaultTest() throws Exception {
        CheckInspectionRequestIo request = new CheckInspectionRequestIo();
        VehiclePassIo vehiclePass = new VehiclePassIo();
        vehiclePass.setVin("ABCDEFG1234567890");
        vehiclePass.setModel("Lada2");
        vehiclePass.setType("Sedan2");
        vehiclePass.setCategory(CategoryIo.C);
        vehiclePass.setBuiltYear(Year.of(1982));
        vehiclePass.setEngineNumber("ABC1232");
        vehiclePass.setChassisNumber("ABC1232");
        vehiclePass.setBodyNumber("ABC1232");
        vehiclePass.setBodyColor("eggplant2");
        request.setVehicle(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        String faultMessage = "Карта осмотра ТС " + vehiclePass.getVin() + " не найдена.";

        mockClient.sendRequest(withPayload(requestSource)).andExpect(new SoapFaultResponseMatcherImpl(faultMessage));
    }

    private static final class SoapFaultResponseMatcherImpl implements ResponseMatcher {

        private final String faultMessage;

        public SoapFaultResponseMatcherImpl(String faultMessage) {
            this.faultMessage = faultMessage;
        }

        @Override
        public void match(WebServiceMessage request, WebServiceMessage response) throws IOException, AssertionError {
            SoapMessage soapResponse = (SoapMessage) response;
            SoapBody responseBody = soapResponse.getSoapBody();
            SoapFault soapFault = responseBody.getFault();
            QName expectedFaultCode = getExpectedFaultCode();
            assertEquals("Invalid SOAP Fault code", expectedFaultCode, soapFault.getFaultCode());
            assertEquals("Invalid SOAP Fault string/reason", faultMessage, soapFault.getFaultStringOrReason());
        }

        protected QName getExpectedFaultCode() {
            return new QName("http://schemas.xmlsoap.org/soap/envelope/", "Server");
        }
    }
}
