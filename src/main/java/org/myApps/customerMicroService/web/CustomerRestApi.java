package org.myApps.customerMicroService.web;

import java.util.List;
import java.util.UUID;


import org.myApps.customerMicroService.dto.CustomerRequestDTO;
import org.myApps.customerMicroService.dto.CustomerResponseDTO;
import org.myApps.customerMicroService.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestApi
{
    CustomerService customerService;
    public CustomerRestApi(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> getAllCustomers(){//ic on utilise pas les entités JPA, mais plutôt les DTO
        return customerService.getAllCustomers();
    }
    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO) {
        /* requestBody nous permet de récuperer un objet "CustomerRequestDTO" à partir de la requete*/

        customerRequestDTO.setId(UUID.randomUUID().toString());//la generation des id va se faire aleatoirement

        return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id) {
        return customerService.getCustomer(id);
    }
}
