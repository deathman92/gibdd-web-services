package ru.vlsu.gibdd.webservice.common.converter;

import ru.vlsu.gibdd.webservice.common.domain.Citizen;

import javax.persistence.AttributeConverter;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
public class GenderTypeConverter implements AttributeConverter<Citizen.Gender, String> {

    @Override
    public String convertToDatabaseColumn(Citizen.Gender attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }

    @Override
    public Citizen.Gender convertToEntityAttribute(String dbData) {
        return Citizen.Gender.fromValue(dbData);
    }
}
