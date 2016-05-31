package ru.vlsu.gibdd.webservice.signature.repository.api;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vlsu.gibdd.webservice.signature.domain.Signature;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Repository
@CacheConfig(cacheNames = "signature")
public interface SignatureRepository extends JpaRepository<Signature, Long> {

    @Cacheable(key = "#p0")
    Signature findByValue(String value);

    @Override
    @CachePut(key = "#result.value")
    <S extends Signature> S save(S signature);
}
