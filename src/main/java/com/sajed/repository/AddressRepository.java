package com.sajed.repository;

import com.sajed.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Address findByAddressIdAndIsDeletedFalse(Integer addressId);
}
