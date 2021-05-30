package ca.limin.service;

import ca.limin.entity.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddresses();
    void saveAddress(Address theAddress);
    Address getAddress(int theId);
}
