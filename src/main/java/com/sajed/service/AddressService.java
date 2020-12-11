package com.sajed.service;

import com.sajed.models.Address;
import com.sajed.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findByAddressIdAndIsDeleted(Integer addressId, Boolean isDeleted){
        return addressRepository.findByAddressIdAndIsDeleted( addressId, isDeleted );
    }

    public Address save( Address address ) {
        return addressRepository.save( address );
    }
}
