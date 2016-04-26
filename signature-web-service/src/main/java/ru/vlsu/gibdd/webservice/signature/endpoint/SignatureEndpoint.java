package ru.vlsu.gibdd.webservice.signature.endpoint;

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
public class SignatureEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(SignatureEndpoint.class);

    @Autowired
    private SignatureService signatureService;

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "GenerateSignatureRequest")
    @ResponsePayload
    public GenerateSignatureResponseIo handle(@RequestPayload GenerateSignatureRequestIo request) {
        logger.info("Handle generateSignature request: " + request);
        GenerateSignatureResponseIo response = signatureService.createSignature(request);
        logger.info("Send back generateSignature response: " + response);
        return response;
    }

    @PayloadRoot(namespace = WebServiceConfig.NAMESPACE_URI, localPart = "VerifySignatureRequest")
    @ResponsePayload
    public VerifySignatureResponseIo handle(@RequestPayload VerifySignatureRequestIo request) {
        logger.info("Handle verifySignature request: " + request);
        VerifySignatureResponseIo response = signatureService.verifySignature(request);
        logger.info("Send back verifySignature response: " + response);
        return response;
    }
}
