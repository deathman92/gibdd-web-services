package ru.vlsu.gibdd.webservice.common.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;

/**
 * @author Victor Zhivotikov
 * @since 10.05.2016
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Configuration
@IntegrationTest
public abstract class AbstractEndpointTest {

    @Autowired
    private ApplicationContext applicationContext;

    protected MockWebServiceClient mockClient;

    @Before
    public void createClient() throws Exception {
        mockClient = MockWebServiceClient.createClient(applicationContext);
    }

    protected JAXBSource getJAXBSource(Object payload) throws Exception {
        JAXBContext context = JAXBContext.newInstance(payload.getClass());
        return new JAXBSource(context, payload);
    }
}
