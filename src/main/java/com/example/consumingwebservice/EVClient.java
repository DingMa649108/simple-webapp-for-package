package com.example.consumingwebservice;

import org.springframework.stereotype.Component;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpUrlConnection;
import org.apache.http.impl.client.HttpClients;
import org.springframework.ws.soap.client.core.SoapActionCallback;


import java.io.IOException;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.net.HttpURLConnection;
import java.util.Map;

import javax.xml.transform.TransformerException;
import javax.xml.namespace.QName;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import org.apache.http.HttpException;

import com.example.consumingwebservice.wsdl.Add;
import com.example.consumingwebservice.wsdl.AddResponse;

@Component
public class evClient extends WebServiceGatewaySupport {

    public AddResponse getResult(int a, int b) {
        final QName soapHeaderName = new QName("SOAPAction", "");
		Add request = new Add();
		request.setIntA(a);
		request.setIntB(b);

	    final WebServiceMessageCallback actionCallback = new SoapActionCallback("http://tempuri.org/Add");
	    final WebServiceMessageCallback customCallback = new WebServiceMessageCallback() {
	        public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
	            actionCallback.doWithMessage(message);
	        }
	    };	
        return (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", request, customCallback);
    }
}
