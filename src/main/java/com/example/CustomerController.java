/**
 * 
 */
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * @author SR4PXM
 *
 */
@RestController
public class CustomerController {
    @Autowired
	CustomerRegistrar customerRegistrar;

	/**
	 * @param customerRegistrar
	 */
	public CustomerController(CustomerRegistrar customerRegistrar) {
		this.customerRegistrar = customerRegistrar;
	}
	
	@RequestMapping( path="/register", method = RequestMethod.POST)
	Mono<Customer> register(@RequestBody Customer customer){		
	 	return customerRegistrar.register(customer);	 
	}

}
