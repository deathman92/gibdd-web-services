package ru.vlsu.gibdd.webservice.inspection.endpoint;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.oxm.support.MarshallingSource;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import ru.vlsu.gibdd.webservice.inspection.exception.CheckInspectionException;
import ru.vlsu.gibdd.webservice.inspection.io.CheckInspectionFaultIo;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

/**
 * @author Victor Zhivotikov
 * @since 26.04.2016
 */
public class FaultExceptionResolver extends SoapFaultMappingExceptionResolver {

    @Override
    protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
        if (ex instanceof CheckInspectionException) {
            CheckInspectionException exception = (CheckInspectionException) ex;
            CheckInspectionFaultIo exceptionFault = exception.getFault();
            SoapFaultDetail faultDetail = fault.addFaultDetail();
            Result result = faultDetail.getResult();
            try {
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
                marshaller.setClassesToBeBound(CheckInspectionFaultIo.class);
                transformer.transform(new MarshallingSource(marshaller, exceptionFault), result);
            } catch (TransformerException te) {
                logger.error("Error transforming checkInspectionFault: " + exceptionFault, te);
            }
        }
    }
}
