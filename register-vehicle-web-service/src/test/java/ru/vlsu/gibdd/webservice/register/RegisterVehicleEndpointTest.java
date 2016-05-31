package ru.vlsu.gibdd.webservice.register;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;
import ru.vlsu.gibdd.webservice.common.io.*;
import ru.vlsu.gibdd.webservice.common.test.AbstractEndpointTest;
import ru.vlsu.gibdd.webservice.register.io.*;
import ru.vlsu.gibdd.webservice.register.service.api.RegistrationNumberService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import java.time.LocalDate;
import java.time.Year;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;

/**
 * @author Victor Zhivotikov
 * @since 10.05.2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("unittest")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegisterVehicleEndpointTest extends AbstractEndpointTest {

    @Autowired
    private ApplicationContext applicationContext;

    protected MockWebServiceClient mockClient;

    @Bean
    public RegistrationNumberService numberService() {
        return mock(RegistrationNumberService.class);
    }

    @Before
    public void createClient() throws Exception {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    @Before
    public void mockService() {
        when(numberService().getNumber()).thenReturn("A000AA");
    }

    @Test
    public void createRegistrationCertificateTest() throws Exception {
        RegisterVehicleRequestIo request = new RegisterVehicleRequestIo();
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

        RegisterVehicleResponseIo response = new RegisterVehicleResponseIo();
        RegistrationCertificateIo registrationCertificate = new RegistrationCertificateIo();
        OwnerIo owner = new OwnerIo();
        owner.setFirstname("First");
        owner.setMiddlename("Middle");
        owner.setLastname("Last");
        owner.setRegion("Region");
        owner.setDistrict("District");
        owner.setCity("City");
        owner.setAddress("Address");
        registrationCertificate.setOwner(owner);
        registrationCertificate.setVehicle(vehiclePass);
        registrationCertificate.setIssueDate(LocalDate.now());
        registrationCertificate.setIssuePlace("Управление ГИБДД УМВД России по Владимирской области");
        registrationCertificate.setRegistrationNumber("A000AA");
        response.setRegistrationCertificate(registrationCertificate);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void findRegistrationCertificateFoundTest() throws Exception {
        FindRegistrationCertificateRequestIo request = new FindRegistrationCertificateRequestIo();
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

        FindRegistrationCertificateResponseIo response = new FindRegistrationCertificateResponseIo();
        RegistrationCertificateIo registrationCertificate = new RegistrationCertificateIo();
        OwnerIo owner = new OwnerIo();
        owner.setFirstname("First");
        owner.setMiddlename("Middle");
        owner.setLastname("Last");
        owner.setRegion("Region");
        owner.setDistrict("District");
        owner.setCity("City");
        owner.setAddress("Address");
        registrationCertificate.setOwner(owner);
        registrationCertificate.setVehicle(vehiclePass);
        registrationCertificate.setIssueDate(LocalDate.now());
        registrationCertificate.setIssuePlace("Управление ГИБДД УМВД России по Владимирской области");
        registrationCertificate.setRegistrationNumber("A000AA");
        response.setResult(true);
        response.setRegistrationCertificate(registrationCertificate);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    @Test
    public void findRegistrationCertificateNotFoundTest() throws Exception {
        FindRegistrationCertificateRequestIo request = new FindRegistrationCertificateRequestIo();
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
        VehiclePassIo vehiclePass = new VehiclePassIo();
        vehiclePass.setVin("ABCDEFG1234567890");
        vehiclePass.setModel("Lada1");
        vehiclePass.setType("Sedan1");
        vehiclePass.setCategory(CategoryIo.A);
        vehiclePass.setBuiltYear(Year.of(1981));
        vehiclePass.setEngineNumber("123ABC");
        vehiclePass.setChassisNumber("123ABC");
        vehiclePass.setBodyNumber("123ABC");
        vehiclePass.setBodyColor("red");
        request.setVehiclePass(vehiclePass);
        JAXBSource requestSource = getJAXBSource(request);

        FindRegistrationCertificateResponseIo response = new FindRegistrationCertificateResponseIo();
        response.setResult(false);
        response.setRegistrationCertificate(null);
        JAXBSource responseSource = getJAXBSource(response);

        mockClient.sendRequest(withPayload(requestSource)).andExpect(payload(responseSource));
    }

    protected JAXBSource getJAXBSource(Object payload) throws Exception {
        JAXBContext context = JAXBContext.newInstance(payload.getClass());
        return new JAXBSource(context, payload);
    }
}
