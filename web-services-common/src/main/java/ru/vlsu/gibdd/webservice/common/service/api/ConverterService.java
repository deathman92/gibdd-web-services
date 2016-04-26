package ru.vlsu.gibdd.webservice.common.service.api;

import java.util.List;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
public interface ConverterService {

    <T> T convert(Object source, Class<T> targetType);
    <T> List<T> convertList(List<?> source, Class<T> targetType);
}