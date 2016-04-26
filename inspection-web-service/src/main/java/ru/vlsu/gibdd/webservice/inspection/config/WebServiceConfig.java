package ru.vlsu.gibdd.webservice.inspection.config;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;
import org.springframework.ws.soap.server.endpoint.interceptor.PayloadValidatingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;
import ru.vlsu.gibdd.webservice.inspection.endpoint.FaultExceptionResolver;
import ru.vlsu.gibdd.webservice.inspection.exception.CheckInspectionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author Victor Zhivotikov
 * @since 25.04.2016
 */
@SuppressWarnings("Duplicates")
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    public static final String NAMESPACE_URI = "http://vlsu.ru/inspection";
    private static final String PORT_TYPE_NAME = "Signature";
    // Order of files is important! XSDs must be listed in order of increasing dependencies
    private static final String[] SCHEMA_LOCATIONS = {  "schema/import/VehiclePassType.xsd",
                                                        "schema/InspectionType.xsd",
                                                        "schema/InspectionWebServiceTypes.xsd"};

    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/services/*");
    }

    @Bean(name = "Inspection")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchemaCollection xsdSchemaCollection) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri("/services/Inspection");
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
        wsdl11Definition.setSchemaCollection(xsdSchemaCollection);
        return wsdl11Definition;
    }

    @Bean
    public SoapFaultMappingExceptionResolver exceptionResolver() {
        SoapFaultMappingExceptionResolver exceptionResolver = new FaultExceptionResolver();

        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
        exceptionResolver.setDefaultFault(faultDefinition);

        Properties exceptionMappings = new Properties();
        exceptionMappings.setProperty(CheckInspectionException.class.getName(), SoapFaultDefinition.SERVER.toString());
        exceptionResolver.setExceptionMappings(exceptionMappings);
        exceptionResolver.setOrder(1);
        return exceptionResolver;
    }

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        PayloadValidatingInterceptor validatingInterceptor = new PayloadValidatingInterceptor();
        validatingInterceptor.setValidateRequest(true);
        validatingInterceptor.setValidateResponse(true);
        validatingInterceptor.setXsdSchemaCollection(xsdSchemaCollection());
        interceptors.add(validatingInterceptor);
    }

    @Bean
    public XsdSchemaCollection xsdSchemaCollection() {
        CommonsXsdSchemaCollection schemaCollection = new CommonsXsdSchemaCollection();
        List<Resource> resources = new ArrayList<>();
        for (String location : SCHEMA_LOCATIONS) {
            resources.add(new ClassPathResource(location));
        }
        Resource[] schemas = new Resource[resources.size()];
        resources.toArray(schemas);
        schemaCollection.setXsds(schemas);
        schemaCollection.setInline(true);
        return schemaCollection;
    }
}
