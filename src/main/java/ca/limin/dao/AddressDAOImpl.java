package ca.limin.dao;

import ca.limin.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Address> getAddresses() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Address> theQuery = currentSession.createQuery("from Address", Address.class);
        List<Address> addresses = theQuery.getResultList();
        return addresses;
    }

    @Override
    public Address getAddress(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Address theAddress = currentSession.get(Address.class, theId);
        return theAddress;
    }

    @Override
    public void saveAddress(Address theAddress) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(theAddress);
    }
}
