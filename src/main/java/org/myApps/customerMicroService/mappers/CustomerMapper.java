package org.myApps.customerMicroService.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.myApps.customerMicroService.dto.CustomerRequestDTO;
import org.myApps.customerMicroService.dto.CustomerResponseDTO;
import org.myApps.customerMicroService.entities.Customer;


@Mapper(componentModel = "spring")// spring qui va injecter l'implémentation de cette interface lorsque l'on met componentMoedl à spring
public interface CustomerMapper
{
   /* @Mappings({//by using this annotation, values are correctly saved in the db, otherwise the fields will contain null values
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "email", source = "email")
    })*/
    // i commented again the annotation above and it works just fine -_-
    CustomerResponseDTO customerToCustomerDTO(Customer customer);
    Customer customerRquestDtoToCustomer(CustomerRequestDTO customerRequestDTO);
}
