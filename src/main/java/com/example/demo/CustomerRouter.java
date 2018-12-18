package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import com.example.bean.ResponseBean;
import com.example.process.GetCustomerByIdProcessor;

@Component
public class CustomerRouter extends RouteBuilder {
	

	@Override
	public void configure() throws Exception {
		/*Map<String, String> reference = new HashMap<String, String>();
        reference.put("getCustomer", GetCustomer.class.getName());
        XStreamDataFormat xstreamDataFormat = new XStreamDataFormat();
        xstreamDataFormat.setAliases(reference);
        xstreamDataFormat.setPermissions(GetCustomer.class.getName());*/
		from("cxf:bean:custTest")
		.log("Customer id is  ${body}")
		.transform(simple("${in.body[0]}"))
		.log("Customer body is  ${body}")
		/*.unmarshal(xstreamDataFormat)*/
		.process(new GetCustomerByIdProcessor())
		.setBody(simple("SELECT * FROM CUSTOMER where cid=${headers.id}"))
		.to("jdbc:datasource")
		.bean(new ResponseBean())
		.to("log:?level=INFO&showBody=true");

	}

}
