package ru.vlsu.gibdd.webservice.blacklist.test.unit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vlsu.gibdd.webservice.blacklist.domain.CitizenBlackList;
import ru.vlsu.gibdd.webservice.blacklist.io.CheckResultIo;
import ru.vlsu.gibdd.webservice.blacklist.repository.api.CitizenBlackListRepository;
import ru.vlsu.gibdd.webservice.blacklist.service.api.CitizenBlackListService;
import ru.vlsu.gibdd.webservice.blacklist.service.impl.CitizenBlackListServiceImpl;
import ru.vlsu.gibdd.webservice.common.domain.Citizen;
import ru.vlsu.gibdd.webservice.common.domain.Passport;
import ru.vlsu.gibdd.webservice.common.domain.Registration;
import ru.vlsu.gibdd.webservice.common.io.CitizenIo;
import ru.vlsu.gibdd.webservice.common.io.GenderIo;
import ru.vlsu.gibdd.webservice.common.io.PassportIo;
import ru.vlsu.gibdd.webservice.common.io.RegistrationIo;
import ru.vlsu.gibdd.webservice.common.repository.api.CitizenRepository;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

/**
 * @author Victor Zhivotikov
 * @since 10.05.2016
 */
@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CitizenBlackListServiceTest {

    @Mock
    private ConverterService converterService;
    @Mock
    private CitizenBlackListRepository citizenBlackListRepository;
    @Mock
    private CitizenRepository citizenRepository;
    @InjectMocks
    private CitizenBlackListService citizenBlackListService = new CitizenBlackListServiceImpl();

    @Before
    public void setUpMocks() {
        when(converterService.convert(getTestCitizenIo(), Citizen.class)).thenReturn(getTestCitizen());
    }

    @Test
    public void checkCitizenSuccessTest() {
        Citizen citizen = getTestCitizen();

        when(citizenRepository.findByPassport(citizen.getPassport())).thenReturn(citizen);
        when(citizenBlackListRepository.findAllByCitizenPassport(citizen.getPassport())).thenReturn(new ArrayList<>());

        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(false);

        assertThat(citizenBlackListService.checkCitizen(getTestCitizenIo())).isEqualTo(checkResult);

        reset(citizenRepository);
        when(citizenRepository.findByPassport(citizen.getPassport())).thenReturn(null);

        assertThat(citizenBlackListService.checkCitizen(getTestCitizenIo())).isEqualTo(checkResult);
    }

    @Test
    public void checkCitizenFailTest() {
        Citizen citizen = getTestCitizen();

        when(citizenRepository.findByPassport(citizen.getPassport())).thenReturn(citizen);
        when(citizenBlackListRepository.findAllByCitizenPassport(citizen.getPassport())).thenReturn(newArrayList(getTestBlackList()));

        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(true);
        checkResult.getMessages().add("Terrorist!");

        assertThat(citizenBlackListService.checkCitizen(getTestCitizenIo())).isEqualTo(checkResult);
    }

    private Citizen getTestCitizen() {
        Citizen citizen = new Citizen();
        citizen.setFirstname("First");
        citizen.setMiddlename("Middle");
        citizen.setLastname("Last");
        citizen.setGender(Citizen.Gender.OTHER);
        citizen.setBirthday(LocalDate.of(1990, 1, 1));
        citizen.setBirthPlace("Place");
        Passport passport = new Passport();
        passport.setSeries("0000");
        passport.setNumber("000000");
        passport.setIssueDate(LocalDate.of(2010, 1, 1));
        passport.setIssuedBy("Place");
        Registration registration = new Registration();
        registration.setRegion("Region");
        registration.setDistrict("District");
        registration.setCity("City");
        registration.setAddress("Address");
        registration.setDate(LocalDate.of(2000, 1, 1));
        passport.setRegistration(registration);
        citizen.setPassport(passport);
        return citizen;
    }

    private CitizenIo getTestCitizenIo() {
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
        return citizen;
    }

    private CitizenBlackList getTestBlackList() {
        CitizenBlackList blackList = new CitizenBlackList();
        blackList.setRecord(getTestCitizen());
        blackList.setStatusMessage("Terrorist!");
        return blackList;
    }
}
