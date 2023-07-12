package com.example.consumingwebservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.assertEquals;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import com.example.consumingwebservice.wsdl.AddResponse;

// @RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestClient {

    // @Autowired
    // private evClient client;

    @Test
    public void TestAdd(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.consumingwebservice.wsdl");

        evClient client = new evClient();
        client.setDefaultUri(null);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        
        int a = 3;
        int b = 6;
        AddResponse response = client.getResult(a,b);
        assertEquals(9, response.getAddResult());
    }
}
