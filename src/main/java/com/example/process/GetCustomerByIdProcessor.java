package com.example.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;


import com.customer.GetCustomerRequest;



public class GetCustomerByIdProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("Processor class");
		GetCustomerRequest custid = (GetCustomerRequest) exchange.getIn().getBody();
		System.out.println("Customer data is "+custid.getId());
		exchange.getIn().setHeader("id", custid.getId());

	}

}
