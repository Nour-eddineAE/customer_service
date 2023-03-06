package org.myApps.customerMicroService.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;

    public CustomerRequestDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
}