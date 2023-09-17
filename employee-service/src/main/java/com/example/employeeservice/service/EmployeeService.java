package com.example.employeeservice.service;

import com.example.employeeservice.model.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse getEmployeeById(Long id);
}
