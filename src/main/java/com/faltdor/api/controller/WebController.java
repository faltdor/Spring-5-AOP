package com.faltdor.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faltdor.api.services.CustomerAdvanceService;
import com.faltdor.api.services.CustomerAnotherService;
import com.faltdor.api.services.CustomerLoggableService;
import com.faltdor.api.services.CustomerService;

@RestController
public class WebController {

	private final CustomerAdvanceService customerAdvanceService;
	private final CustomerAnotherService customerAnotherService;
	private final CustomerLoggableService customerLoggableService;
	private final CustomerService customerService;

	public WebController(CustomerAdvanceService customerAdvanceService, CustomerAnotherService customerAnotherService,
			CustomerLoggableService customerLoggableService, CustomerService customerService) {
		this.customerAdvanceService = customerAdvanceService;
		this.customerAnotherService = customerAnotherService;
		this.customerLoggableService = customerLoggableService;
		this.customerService = customerService;
	}

	@RequestMapping("/aspectnormal")
	public String normalAspect() {
		StringBuilder result = new StringBuilder();

		result.append(customerService.getCustomerById(1).getFirstName());
		result.append(customerService.setCustomerFirstName("Peter", 1));
		result.append(customerService.setCustomerLastName("Levin", 2));

		return result.toString();
	}

	@RequestMapping("/aspectpointcut")
	public String pointcutAspect() {
		StringBuilder result = new StringBuilder();

		result.append(customerAnotherService.findCustomerByLastName("Smith"));
		result.append(customerAnotherService.findAllCustomers());

		return result.toString();
	}

	@RequestMapping("/aspectjoinpoint")
	public String joinpointAspect() {
		StringBuilder result = new StringBuilder();

		result.append(customerAdvanceService.setCustomerFirstName("Peter", 1));
		result.append(customerAdvanceService.findAllCustomers());

		return result.toString();
	}

	@RequestMapping("/aspectloggable")
	public String loggableAspect() {
		return customerLoggableService.getCustomerById(1).getFirstName();
	}

}
