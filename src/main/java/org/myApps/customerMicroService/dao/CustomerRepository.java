package org.myApps.customerMicroService.dao;


import org.myApps.customerMicroService.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
