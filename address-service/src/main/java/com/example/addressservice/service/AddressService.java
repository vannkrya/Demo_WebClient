package com.example.addressservice.service;

import com.example.addressservice.model.response.AddressResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressService {
    AddressResponse findAddressByEmployeeId(@Param("id") Long id);

    List<AddressResponse> getAllAddresses();
}
