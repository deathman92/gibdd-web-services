package ru.vlsu.gibdd.webservice.common.converter;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.vlsu.gibdd.webservice.common.io.AbstractIo;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Component
@Qualifier("ioConverter")
public abstract class AbstractIoConverter<S, T extends AbstractIo> extends AbstractTwoWayConverter<S, T> {

    @Autowired
    @Getter
    private ConverterService converterService;
}
