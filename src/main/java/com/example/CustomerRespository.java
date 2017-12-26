/**
 * 
 */
package com.example;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


/**
 * @author SR4PXM
 *
 */
@RepositoryRestResource
public interface CustomerRespository extends JpaRepository<Customer, Long>{

	/**
	 * 
	 */
	Optional<Customer> findByFname(@Param("fname") String fname);
}
