package com.example.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.customer.GetCustomerResponse;

import com.thoughtworks.xstream.XStream;

public class XmlFormatProcess implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		XStream xstream = new XStream();
	   
	    xstream.alias("getCustomerResponse", GetCustomerResponse.class);
	    xstream.addImplicitCollection(GetCustomerResponse.class, "getCustomerResponse");
		
		GetCustomerResponse cust = null;
		
		
		Map<?, ?> customerDetailsMap = null;

		List<?> customerDetailsList = (List<?>) exchange.getIn().getBody();
		System.out.println(customerDetailsList);

		if (customerDetailsList != null && customerDetailsList.size() > 0) {
			for(int i=0; i<customerDetailsList.size();i++) {
				cust=new GetCustomerResponse();
			customerDetailsMap = (Map<?, ?>) customerDetailsList.get(i);
			cust.setId((Integer) customerDetailsMap.get("cid"));
			cust.setName(customerDetailsMap.get("cname").toString());
			cust.setEmail(customerDetailsMap.get("email").toString());
			cust.setLocation(customerDetailsMap.get("location").toString());
			System.out.println((Integer) customerDetailsMap.get("cid"));
			System.out.println(customerDetailsMap.get("cname").toString());
			System.out.println(customerDetailsMap.get("email").toString());
			System.out.println(customerDetailsMap.get("location").toString());
			
			
			}

		}
		
	    String xml = xstream.toXML(cust);
	    System.out.println(xml);
	    exchange.getIn().setBody(xml);
		/*customers.setCustomer(listCustomer);
		JAXBContext context = JAXBContext.newInstance(Customers.class);
		Marshaller m = context.createMarshaller(); // for pretty-print XML in JAXB
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		StringWriter writer = new StringWriter(); // Write to list to a writer
		m.marshal(customers, writer);
		
		exchange.getIn().setBody(m);*/

	}
}
