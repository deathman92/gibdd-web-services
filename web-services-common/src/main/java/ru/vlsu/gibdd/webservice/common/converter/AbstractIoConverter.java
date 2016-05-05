package ru.vlsu.gibdd.webservice.common.converter;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.vlsu.gibdd.webservice.common.annotation.IoConverter;
import ru.vlsu.gibdd.webservice.common.domain.AbstractDomain;
import ru.vlsu.gibdd.webservice.common.io.AbstractIo;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@IoConverter
public abstract class AbstractIoConverter<S, T extends AbstractIo> extends AbstractTwoWayConverter<S, T> {

    @Autowired
    @Getter
    private ConverterService converterService;
}
