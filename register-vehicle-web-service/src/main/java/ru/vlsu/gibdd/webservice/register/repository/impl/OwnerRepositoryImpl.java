package ru.vlsu.gibdd.webservice.register.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vlsu.gibdd.webservice.register.domain.Owner;
import ru.vlsu.gibdd.webservice.register.repository.api.OwnerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
public class OwnerRepositoryImpl implements OwnerRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Owner findOwner(Owner owner) {
        Query query = entityManager.createQuery("select o from Owner o " +
                "where o.firstname = :firstname and o.middlename = :middlename and o.lastname = :lastname " +
                "and o.region = :region and o.district = :district and o.city = :city and o.address = :address", Owner.class);
        query.setParameter("firstname", owner.getFirstname());
        query.setParameter("middlename", owner.getMiddlename());
        query.setParameter("lastname", owner.getLastname());
        query.setParameter("region", owner.getRegion());
        query.setParameter("district", owner.getDistrict());
        query.setParameter("city", owner.getCity());
        query.setParameter("address", owner.getAddress());

        try {
            return (Owner) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
