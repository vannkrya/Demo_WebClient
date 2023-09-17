package com.example.addressservice.service.serviceImplement;

import com.example.addressservice.model.entity.Address;
import com.example.addressservice.model.response.AddressResponse;
import com.example.addressservice.repository.AddressRepository;
import com.example.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImplement implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public AddressResponse findAddressByEmployeeId(Long id) {
        Address address = addressRepository.findAddressByEmployeeId(id);
        return modelMapper.map(address, AddressResponse.class);
    }

    @Override
    public List<AddressResponse> getAllAddresses() {
//        List<Address> addressList = addressRepository.findAll();
//        return modelMapper.map();
        return null;
    }

}
