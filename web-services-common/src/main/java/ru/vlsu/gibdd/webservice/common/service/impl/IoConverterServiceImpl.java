package ru.vlsu.gibdd.webservice.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.vlsu.gibdd.webservice.common.service.api.ConverterService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Service
@Qualifier("ioConverterService")
public class IoConverterServiceImpl extends GenericConversionService implements ConverterService {

    @Autowired(required = false)
    @Qualifier("io")
    private List<Converter> converters;
    @Autowired(required = false)
    @Qualifier("io")
    private List<GenericConverter> genericConverters;

    @PostConstruct
    public void afterPropertiesSet() {
        Set<Object> allConverters = new HashSet<>();
        if (!CollectionUtils.isEmpty(converters)) {
            allConverters.addAll(converters);
        }
        if (!CollectionUtils.isEmpty(genericConverters)) {
            allConverters.addAll(genericConverters);
        }
        if (!CollectionUtils.isEmpty(allConverters)) {
            ConversionServiceFactory.registerConverters(allConverters, this);
        }
    }

    @Override
    public <T> List<T> convertList(List<?> source, Class<T> targetType) {
        List<T> result = new ArrayList<>();
        for (Object o : source) {
            result.add(convert(o, targetType));
        }
        return result;
    }
}
