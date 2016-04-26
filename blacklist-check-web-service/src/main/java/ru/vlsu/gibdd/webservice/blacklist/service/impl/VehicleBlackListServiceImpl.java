package ru.vlsu.gibdd.webservice.blacklist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.gibdd.webservice.blacklist.domain.VehicleBlackList;
import ru.vlsu.gibdd.webservice.common.domain.VehiclePass;
import ru.vlsu.gibdd.webservice.blacklist.io.CheckResultIo;
import ru.vlsu.gibdd.webservice.blacklist.repository.api.VehicleBlackListRepository;
import ru.vlsu.gibdd.webservice.common.io.VehiclePassIo;
import ru.vlsu.gibdd.webservice.common.repository.api.VehiclePassRepository;
import ru.vlsu.gibdd.webservice.blacklist.service.api.VehicleBlackListService;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Service
public class VehicleBlackListServiceImpl implements VehicleBlackListService {

    @Autowired
    @Qualifier("ioConverterService")
    private ConverterService converterService;
    @Autowired
    private VehicleBlackListRepository vehicleBlackListRepository;
    @Autowired
    private VehiclePassRepository vehiclePassRepository;

    @Override
    @Transactional
    public CheckResultIo checkVehicle(VehiclePassIo vehiclePassIo) {
        VehiclePass vehiclePass = converterService.convert(vehiclePassIo, VehiclePass.class);
        VehiclePass inVehiclePass = vehiclePassRepository.findByVin(vehiclePass.getVin());
        if (inVehiclePass == null) {
            vehiclePassRepository.save(vehiclePass);
            return buildResult(null);
        }
        List<VehicleBlackList> blackLists = vehicleBlackListRepository.findAllByVehicle(inVehiclePass);
        return buildResult(blackLists);
    }

    private CheckResultIo buildResult(List<VehicleBlackList> blackLists) {
        CheckResultIo resultIo = new CheckResultIo();
        if (blackLists == null || blackLists.size() == 0) {
            resultIo.setResult(false);
        } else {
            resultIo.setResult(true);
            for (VehicleBlackList blackList : blackLists) {
                resultIo.getMessages().add(blackList.getStatusMessage());
            }
        }
        return resultIo;
    }
}
