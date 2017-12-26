/**
 * 
 */
package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

/**
 * @author SR4PXM
 *
 */
@Component
@Lazy
public class CustomerRegistrar {
	@Autowired
	CustomerRespository customerRespository;

	/**
	 * 
	 */
	public CustomerRegistrar() {
	
	}

	/**
	 * @param customerRespository
	 */
	public CustomerRegistrar(CustomerRespository customerRespository) {
		this.customerRespository = customerRespository;
	}
	
	// ideally repository will return a Mono object
		public Mono<Customer> register(Customer customer){
			if(customer.getFname()!= null && customerRespository.findByFname(customer.getFname()).isPresent())
				System.out.println("Duplicate Customer. No Action required");
			else { 
				customerRespository.save(customer); 
				//sender.send(customer.getEmail());		
			}
		return Mono.just(customer);
			
		}

}
