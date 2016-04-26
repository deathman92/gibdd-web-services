package ru.vlsu.gibdd.webservice.blacklist.domain;

import ru.vlsu.gibdd.webservice.common.domain.Citizen;

import javax.persistence.Entity;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Entity
public class CitizenBlackList extends AbstractBlackList<Citizen> {
}
