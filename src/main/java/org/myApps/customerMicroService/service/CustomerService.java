package org.myApps.customerMicroService.service;

import java.util.List;

import org.myApps.customerMicroService.dto.CustomerRequestDTO;
import org.myApps.customerMicroService.dto.CustomerResponseDTO;


public interface CustomerService
{
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    public CustomerResponseDTO getCustomer(String id);
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    public List<CustomerResponseDTO> getAllCustomers();
}
