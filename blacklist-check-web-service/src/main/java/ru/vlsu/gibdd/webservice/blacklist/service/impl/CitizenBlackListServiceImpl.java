package ru.vlsu.gibdd.webservice.blacklist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.gibdd.webservice.common.domain.Citizen;
import ru.vlsu.gibdd.webservice.blacklist.domain.CitizenBlackList;
import ru.vlsu.gibdd.webservice.blacklist.io.CheckResultIo;
import ru.vlsu.gibdd.webservice.blacklist.repository.api.CitizenBlackListRepository;
import ru.vlsu.gibdd.webservice.common.io.CitizenIo;
import ru.vlsu.gibdd.webservice.common.repository.api.CitizenRepository;
import ru.vlsu.gibdd.webservice.blacklist.service.api.CitizenBlackListService;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Service
public class CitizenBlackListServiceImpl implements CitizenBlackListService {

    @Autowired
    @Qualifier("ioConverterService")
    private ConverterService converterService;
    @Autowired
    private CitizenBlackListRepository citizenBlackListRepository;
    @Autowired
    private CitizenRepository citizenRepository;

    @Override
    @Transactional(readOnly = true)
    public CheckResultIo checkCitizen(CitizenIo citizenIo) {
        Citizen citizen = converterService.convert(citizenIo, Citizen.class);
        Citizen inCitizen = citizenRepository.findByPassport(citizen.getPassport());
        if (inCitizen == null) {
            citizenRepository.save(citizen);
            return buildResult(null);
        }
        List<CitizenBlackList> blackLists = citizenBlackListRepository.findAllByCitizenPassport(inCitizen.getPassport());
        return buildResult(blackLists);
    }

    private CheckResultIo buildResult(List<CitizenBlackList> blackLists) {
        CheckResultIo resultIo = new CheckResultIo();
        if (blackLists == null || blackLists.size() == 0) {
            resultIo.setResult(false);
        } else {
            resultIo.setResult(true);
            for (CitizenBlackList blackList : blackLists) {
                resultIo.getMessages().add(blackList.getStatusMessage());
            }
        }
        return resultIo;
    }
}
