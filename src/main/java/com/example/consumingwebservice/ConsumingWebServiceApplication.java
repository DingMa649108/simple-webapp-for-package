package com.example.consumingwebservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.consumingwebservice.wsdl.Add;
import com.example.consumingwebservice.wsdl.AddResponse;

@SpringBootApplication
public class ConsumingWebServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConsumingWebServiceApplication.class, args);
  }

  @Bean
  CommandLineRunner lookup(evClient quoteClient) {
    return args -> {

		AddResponse response = quoteClient.getResult(3, 7);
    System.err.println("the add result is: " + response.getAddResult());
    };
  }

}