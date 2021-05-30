package ca.limin.service;

import ca.limin.dao.AddressDAO;
import ca.limin.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressDAO addressDAO;

    @Override
    @Transactional
    public List<Address> getAddresses() {
        return addressDAO.getAddresses();
    }

    @Override
    @Transactional
    public Address getAddress(int theId) {
        return addressDAO.getAddress(theId);
    }

    @Override
    @Transactional
    public void saveAddress(Address theAddress) {
        addressDAO.saveAddress(theAddress);
    }
}
