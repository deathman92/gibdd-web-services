package ru.vlsu.gibdd.webservice.common.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author Victor Zhivotikov
 * @since 02.04.2016
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
@Qualifier("io")
@Inherited
public @interface IoConverter {
}
