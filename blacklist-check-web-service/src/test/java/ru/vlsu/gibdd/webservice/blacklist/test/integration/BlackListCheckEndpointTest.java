package ru.vlsu.gibdd.webservice.blacklist.test.integration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import ru.vlsu.gibdd.webservice.blacklist.Application;
import ru.vlsu.gibdd.webservice.blacklist.io.*;
import ru.vlsu.gibdd.webservice.common.io.*;
import ru.vlsu.gibdd.webservice.common.test.AbstractEndpointTest;

import javax.xml.bind.util.JAXBSource;
import java.time.LocalDate;
import java.time.Year;

import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("integtest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners(DbUnitTestExecutionListener.class)
@DatabaseSetup("/db/db-entities.xml")
public class BlackListCheckEndpointTest extends AbstractEndpointTest {

    @Test
    public void checkCitizenNotFound() throws Exception {
        CheckCitizenRequestIo request = new CheckCitizenRequestIo();
        CitizenIo citizen = new CitizenIo();
        citizen.setFirstname("First1");
        citizen.setMiddlename("Middle1");
        citizen.setLastname("Last1");
        citizen.setGender(GenderIo.MALE);
        citizen.setBirthday(LocalDate.of(1991, 2, 2));
        citizen.setBirthPlace("Place1");
        PassportIo passport = new PassportIo();
        passport.setSeries("1111");
        passport.setNumber("111111");
        passport.setIssueDate(LocalDate.of(2011, 2, 2));
        passport.setIssuedBy("Place1");
        RegistrationIo registration = new RegistrationIo();
        registration.setRegion("Region1");
        registration.setDistrict("District1");
        registration.setCity("City1");
        registration.setAddress("Address1");
        registration.setDate(LocalDate.of(2001, 2, 2));
        passport.setRegistration(registration);
        citizen.setPassport(passport);
        request.setCitizen(citizen);
        JAXBSource requestSource = getJAXBSource(request);

        CheckCitizenResponseIo response = new CheckCitizenResponseIo();
        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(false);
        response.setResult(checkResult);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void checkCitizenFound() throws Exception {
        CheckCitizenRequestIo request = new CheckCitizenRequestIo();
        CitizenIo citizen = new CitizenIo();
        citizen.setFirstname("First");
        citizen.setMiddlename("Middle");
        citizen.setLastname("Last");
        citizen.setGender(GenderIo.OTHER);
        citizen.setBirthday(LocalDate.of(1990, 1, 1));
        citizen.setBirthPlace("Place");
        PassportIo passport = new PassportIo();
        passport.setSeries("0000");
        passport.setNumber("000000");
        passport.setIssueDate(LocalDate.of(2010, 1, 1));
        passport.setIssuedBy("Place");
        RegistrationIo registration = new RegistrationIo();
        registration.setRegion("Region");
        registration.setDistrict("District");
        registration.setCity("City");
        registration.setAddress("Address");
        registration.setDate(LocalDate.of(2000, 1, 1));
        passport.setRegistration(registration);
        citizen.setPassport(passport);
        request.setCitizen(citizen);
        JAXBSource requestSource = getJAXBSource(request);

        CheckCitizenResponseIo response = new CheckCitizenResponseIo();
        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(true);
        checkResult.getMessages().add("Terrorist!");
        checkResult.getMessages().add("Gangster!");
        response.setResult(checkResult);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void checkVehicleNotFound() throws Exception {
        CheckVehicleRequestIo request = new CheckVehicleRequestIo();
        VehiclePassIo vehiclePass = new VehiclePassIo();
        vehiclePass.setVin("ABCDEFG1234567890");
        vehiclePass.setModel("Test");
        vehiclePass.setType("Test");
        vehiclePass.setCategory(CategoryIo.A);
        vehiclePass.setBuiltYear(Year.of(1981));
        vehiclePass.setEngineNumber("ENumber");
        vehiclePass.setChassisNumber("CNumber");
        vehiclePass.setBodyNumber("BNumber");
        vehiclePass.setBodyColor("Red");
        request.setVehiclePass(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        CheckVehicleResponseIo response = new CheckVehicleResponseIo();
        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(false);
        response.setResult(checkResult);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void checkVehicleFound() throws Exception {
        CheckVehicleRequestIo request = new CheckVehicleRequestIo();
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
        request.setVehiclePass(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        CheckVehicleResponseIo response = new CheckVehicleResponseIo();
        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(true);
        checkResult.getMessages().add("Stolen!");
        response.setResult(checkResult);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }
}
