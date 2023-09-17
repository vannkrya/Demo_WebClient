package com.example.addressservice.controller;

import com.example.addressservice.model.response.AddressResponse;
import com.example.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/addresses/{id}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable Long id) {
        AddressResponse addressResponse = addressService.findAddressByEmployeeId(id);
        return ResponseEntity.status(HttpStatus.OK).body(addressResponse);
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        List<AddressResponse> addressResponseList = addressService.getAllAddresses();
        return ResponseEntity.status(HttpStatus.OK).body(addressResponseList);
    }
}
