package com.example.consumingwebservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@ComponentScan(basePackages = "com.example.consumingwebservice")
public class TestConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.example.consumingwebservice.wsdl");
    return marshaller;
  }

  @Bean
  public evClient evClient(Jaxb2Marshaller marshaller) {
    evClient client = new evClient();
    client.setDefaultUri(null);
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}