package ru.vlsu.gibdd.webservice.common.converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
public abstract class AbstractTwoWayConverter<S, T> implements GenericConverter {

    private Class<S> classOfS;
    private Class<T> classOfT;

    @SuppressWarnings("unchecked")
    protected AbstractTwoWayConverter() {
        Type typeS = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Type typeT = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.classOfS = (Class) typeS;
        this.classOfT = (Class) typeT;
    }

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(classOfS, classOfT));
        convertiblePairs.add(new ConvertiblePair(classOfT, classOfS));
        return convertiblePairs;
    }

    @Override
    @SuppressWarnings("unchecked")
    @SneakyThrows
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }
        if (classOfS.equals(sourceType.getType())) {
            return convert((S) source, classOfT.newInstance());
        } else {
            return convertBack((T) source, classOfS.newInstance());
        }
    }

    protected abstract T convert(S source, T target);

    protected abstract S convertBack(T source, S target);
}
