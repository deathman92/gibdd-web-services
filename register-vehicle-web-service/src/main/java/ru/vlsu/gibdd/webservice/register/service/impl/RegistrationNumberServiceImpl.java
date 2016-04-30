package ru.vlsu.gibdd.webservice.register.service.impl;

import org.springframework.stereotype.Service;
import ru.vlsu.gibdd.webservice.register.service.api.RegistrationNumberService;

import java.util.Random;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@Service
public class RegistrationNumberServiceImpl implements RegistrationNumberService {

    private final String FORMAT = "%d%s%s%s%d%d";
    private final String[] LETTERS = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};

    @Override
    public String getNumber() {
        Random random = new Random();
        return String.format(FORMAT,
                random.nextInt(10),
                LETTERS[random.nextInt(12)],
                LETTERS[random.nextInt(12)],
                LETTERS[random.nextInt(12)],
                random.nextInt(10),
                random.nextInt(10)
            );
    }
}
