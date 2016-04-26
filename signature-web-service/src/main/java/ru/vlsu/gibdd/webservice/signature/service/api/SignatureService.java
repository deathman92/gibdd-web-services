package ru.vlsu.gibdd.webservice.signature.service.api;

import ru.vlsu.gibdd.webservice.signature.io.GenerateSignatureRequestIo;
import ru.vlsu.gibdd.webservice.signature.io.GenerateSignatureResponseIo;
import ru.vlsu.gibdd.webservice.signature.io.VerifySignatureRequestIo;
import ru.vlsu.gibdd.webservice.signature.io.VerifySignatureResponseIo;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
public interface SignatureService {

    GenerateSignatureResponseIo createSignature(GenerateSignatureRequestIo request);
    VerifySignatureResponseIo verifySignature(VerifySignatureRequestIo request);
}
