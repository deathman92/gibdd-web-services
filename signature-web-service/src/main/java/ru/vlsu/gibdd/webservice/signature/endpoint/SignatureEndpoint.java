package ru.vlsu.gibdd.webservice.signature.endpoint;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.vlsu.gibdd.webservice.signature.config.WebServiceConfig;
import ru.vlsu.gibdd.webservice.signature.io.GenerateSignatureRequestIo;
import ru.vlsu.gibdd.webservice.signature.io.GenerateSignatureResponseIo;
import ru.vlsu.gibdd.webservice.signature.io.VerifySignatureRequestIo;
import ru.vlsu.gibdd.webservice.signature.io.VerifySignatureResponseIo;
import ru.vlsu.gibdd.webservice.signature.service.api.SignatureService;

/**
 * @author Victor Zhivotikov
 * @since 01.04.2016
 */
@Endpoint
@Slf4j
public class SignatureEndpoint {

    @Autowired
    private SignatureService signatureService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "GenerateSignatureRequest")
    @ResponsePayload
    public GenerateSignatureResponseIo handle(@RequestPayload GenerateSignatureRequestIo request) {
        log.info("Handle generateSignature request: " + request);
        GenerateSignatureResponseIo response = signatureService.createSignature(request);
        log.info("Send back generateSignature response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "VerifySignatureRequest")
    @ResponsePayload
    public VerifySignatureResponseIo handle(@RequestPayload VerifySignatureRequestIo request) {
        log.info("Handle verifySignature request: " + request);
        VerifySignatureResponseIo response = signatureService.verifySignature(request);
        log.info("Send back verifySignature response: " + response);
        return response;
    }
}
