package com.example.employeeservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeResponse {

    private Long id;
    private String name;
    private String email;
    private String age;
    private AddressResponse addressResponse;

}
