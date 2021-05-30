package ca.limin.dao;

import ca.limin.entity.Address;

import java.util.List;

public interface AddressDAO {
    List<Address> getAddresses();
    void saveAddress(Address theAddress);
    Address getAddress(int theId);
}
