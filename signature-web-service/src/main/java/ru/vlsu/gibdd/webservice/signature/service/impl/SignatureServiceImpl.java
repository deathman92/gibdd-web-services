package ru.vlsu.gibdd.webservice.signature.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.gibdd.webservice.signature.domain.Signature;
import ru.vlsu.gibdd.webservice.signature.io.GenerateSignatureRequestIo;
import ru.vlsu.gibdd.webservice.signature.io.GenerateSignatureResponseIo;
import ru.vlsu.gibdd.webservice.signature.io.VerifySignatureRequestIo;
import ru.vlsu.gibdd.webservice.signature.io.VerifySignatureResponseIo;
import ru.vlsu.gibdd.webservice.signature.repository.api.SignatureRepository;
import ru.vlsu.gibdd.webservice.signature.service.api.SignatureService;

import java.math.BigInteger;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
@Service
public class SignatureServiceImpl implements SignatureService {

    @Autowired
    private SignatureRepository signatureRepository;

    @Override
    @Transactional
    public GenerateSignatureResponseIo createSignature(GenerateSignatureRequestIo request) {
        BigInteger hash = BigInteger.valueOf(request.hashCode());
        String signature = UUID.nameUUIDFromBytes(hash.toByteArray()).toString();
        Signature foundSignature = signatureRepository.findByValue(signature);
        if (foundSignature == null) {
            foundSignature = new Signature();
            foundSignature.setValue(signature);
            signatureRepository.save(foundSignature);
        }
        GenerateSignatureResponseIo response = new GenerateSignatureResponseIo();
        response.setSignatue(foundSignature.getValue());
        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public VerifySignatureResponseIo verifySignature(VerifySignatureRequestIo request) {
        VerifySignatureResponseIo response = new VerifySignatureResponseIo();
        boolean result = false;
        Signature signature = signatureRepository.findByValue(request.getSignature());
        if (signature != null) {
            result = true;
        }
        response.setResult(result);
        return response;
    }
}
