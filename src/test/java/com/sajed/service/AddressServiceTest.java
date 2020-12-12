package com.sajed.service;

import com.sajed.main.FamilyApplication;
import com.sajed.models.Address;
import com.sajed.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = FamilyApplication.class)
class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @MockBean
    private AddressRepository addressRepository;

    @BeforeEach
    void setUp() {
        Address mirpurBD = new Address();
        mirpurBD.setAddressId(1);
        Address parkStreetSingapore = new Address();
        parkStreetSingapore.setAddressId(2);

        Mockito.when(addressService.findByAddressIdAndIsDeletedFalse(
                mirpurBD.getAddressId())).thenReturn(mirpurBD);
        Mockito.when(addressService.save(parkStreetSingapore)).thenReturn(parkStreetSingapore);
        Mockito.when(addressService.findByAddressIdAndIsDeletedFalse(4)).thenReturn(null);
    }


    @Test
    public void givenAnExistingAddressReturnAddress() {
        Address mirpurBD = new Address();
        mirpurBD.setAddressId(1);

        Address output = addressService.findByAddressIdAndIsDeletedFalse(mirpurBD.getAddressId());
        assertEquals(mirpurBD, output);

    }

    @Test
    public void givenAnNonExistingAddressReturnNull() {

        Address output = addressService.findByAddressIdAndIsDeletedFalse(4);
        assertEquals(null, output);

    }


    @Test
    public void save() {
        Address parkStreetSingapore = new Address();
        parkStreetSingapore.setAddressId(2);

        Address found = addressService.save(parkStreetSingapore);
        assertEquals(parkStreetSingapore, found);

    }

}