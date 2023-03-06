package org.myApps.customerMicroService.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.myApps.customerMicroService.dao.CustomerRepository;
import org.myApps.customerMicroService.dto.CustomerRequestDTO;
import org.myApps.customerMicroService.dto.CustomerResponseDTO;
import org.myApps.customerMicroService.entities.Customer;
import org.myApps.customerMicroService.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService
{
    // on peut injecter dynamiquement enn utilisant @Autowired mais c'est dépricié
    private CustomerMapper customerMapper;
    private CustomerRepository customerRepository;
    //@Autowired//optionnel si la classe a un seul constructeur
    public CustomerServiceImplementation(CustomerRepository customerRepository,CustomerMapper customerMapper) {
        super();
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;

    }
    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        // il va falloir d'abord transformer l'objet customerRequestDTO reçu de l'interface graphique en un objet customer

	/*
		 //Mapping Objet Objet

		Customer customer = new Customer();
		customer.setId(customerRequestDTO.getId());
		customer.setName(customerRequestDTO.getName());
		customer.setEmail(customerRequestDTO.getEmail());
		//customer.setId(UUID.randomUUID().toString());//ceci genere des id dans la couche service, pas via la base de données
		Customer savedCustomer = customerRepository.save(customer);
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		 //Mapping Objet Objet

		customerResponseDTO.setId(savedCustomer.getId());
		customerResponseDTO.setName(savedCustomer.getName());
		customerResponseDTO.setEmail(savedCustomer.getEmail());

		/*
		 * tout ce mapping en dessus peut etre fait avec le customerMapper
		 */
        Customer customer = customerMapper.customerRquestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Optional<Customer> optCustomer = customerRepository.findById(id);
        Customer customer = optCustomer.orElse(null);// trouver l'objet Customer en premier
        if(customer == null)
            throw new IllegalArgumentException("No customer with such id");
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerDTO(customer);//aprés le transformer en DTO
        return customerResponseDTO;
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerMapper.customerRquestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerResponseDTO customerResponseDTO = customerMapper.customerToCustomerDTO(savedCustomer);
        return customerResponseDTO;
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
//		List<CustomerResponseDTO> listOfCustomerResponseDTO = customers.stream().map(
//				customer->customerMapper.customerRquestDtoToCustomer(customer)).
//				collect(Collectors.toList());
        List<CustomerResponseDTO> listOfCustomersResponseDTO= customers.stream()
                .map(customer->customerMapper
                        .customerToCustomerDTO(customer))
                .collect(Collectors.toList());
        return listOfCustomersResponseDTO;
    }
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e){
        return e.getMessage();
    }

}
