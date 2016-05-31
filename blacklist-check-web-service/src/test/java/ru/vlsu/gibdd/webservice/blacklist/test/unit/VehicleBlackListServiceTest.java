package ru.vlsu.gibdd.webservice.blacklist.test.unit;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.vlsu.gibdd.webservice.blacklist.domain.CitizenBlackList;
import ru.vlsu.gibdd.webservice.blacklist.domain.VehicleBlackList;
import ru.vlsu.gibdd.webservice.blacklist.io.CheckResultIo;
import ru.vlsu.gibdd.webservice.blacklist.repository.api.VehicleBlackListRepository;
import ru.vlsu.gibdd.webservice.blacklist.service.api.VehicleBlackListService;
import ru.vlsu.gibdd.webservice.blacklist.service.impl.CitizenBlackListServiceImpl;
import ru.vlsu.gibdd.webservice.blacklist.service.impl.VehicleBlackListServiceImpl;
import ru.vlsu.gibdd.webservice.common.domain.Citizen;
import ru.vlsu.gibdd.webservice.common.domain.Passport;
import ru.vlsu.gibdd.webservice.common.domain.Registration;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.common.io.*;
import ru.vlsu.gibdd.webservice.common.repository.api.VehiclePassRepository;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

import java.time.LocalDate;
import java.time.Year;
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
public class VehicleBlackListServiceTest {

    @Mock
    private ConverterService converterService;
    @Mock
    private VehicleBlackListRepository vehicleBlackListRepository;
    @Mock
    private VehiclePassRepository vehiclePassRepository;
    @InjectMocks
    private VehicleBlackListService vehicleBlackListService = new VehicleBlackListServiceImpl();

    @Before
    public void setUpMocks() {
        when(converterService.convert(getTestVehiclePassIo(), VehiclePass.class)).thenReturn(getTestVehiclePass());
    }

    @Test
    public void checkCitizenSuccessTest() {
        VehiclePass vehiclePass = getTestVehiclePass();

        when(vehiclePassRepository.findByVin(vehiclePass.getVin())).thenReturn(vehiclePass);
        when(vehicleBlackListRepository.findAllByVehicle(vehiclePass)).thenReturn(new ArrayList<>());

        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(false);

        assertThat(vehicleBlackListService.checkVehicle(getTestVehiclePassIo())).isEqualTo(checkResult);

        reset(vehiclePassRepository);
        when(vehiclePassRepository.findByVin(vehiclePass.getVin())).thenReturn(null);

        assertThat(vehicleBlackListService.checkVehicle(getTestVehiclePassIo())).isEqualTo(checkResult);
    }

    @Test
    public void checkCitizenFailTest() {
        VehiclePass vehiclePass = getTestVehiclePass();

        when(vehiclePassRepository.findByVin(vehiclePass.getVin())).thenReturn(vehiclePass);
        when(vehicleBlackListRepository.findAllByVehicle(vehiclePass)).thenReturn(newArrayList(getTestBlackList()));

        CheckResultIo checkResult = new CheckResultIo();
        checkResult.setResult(true);
        checkResult.getMessages().add("Stolen!");

        assertThat(vehicleBlackListService.checkVehicle(getTestVehiclePassIo())).isEqualTo(checkResult);
    }

    private VehiclePass getTestVehiclePass() {
        VehiclePass vehiclePass = new VehiclePass();
        vehiclePass.setVin("1234567890ABCDEFG");
        vehiclePass.setModel("Lada");
        vehiclePass.setType("Sedan");
        vehiclePass.setCategory(VehiclePass.Category.B);
        vehiclePass.setBuiltYear(Year.of(1980));
        vehiclePass.setEngineNumber("ABC123");
        vehiclePass.setChassisNumber("ABC123");
        vehiclePass.setBodyNumber("ABC123");
        vehiclePass.setBodyColor("eggplant");
        return vehiclePass;
    }

    private VehiclePassIo getTestVehiclePassIo() {
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
        return vehiclePass;
    }

    private VehicleBlackList getTestBlackList() {
        VehicleBlackList blackList = new VehicleBlackList();
        blackList.setRecord(getTestVehiclePass());
        blackList.setStatusMessage("Stolen!");
        return blackList;
    }
}
