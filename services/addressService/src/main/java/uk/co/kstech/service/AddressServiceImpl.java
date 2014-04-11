package uk.co.kstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.kstech.dao.address.AddressDao;
import uk.co.kstech.model.address.Address;

/**
 * Created by KMcGivern on 10/04/2014.
 */
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;

    @Override
    public Address getAddress(final long id) {
        return addressDao.findOne(id);
    }

    @Override
    public Address createAddress(final Address address) {
        return addressDao.save(address);
    }

    @Override
    public Address updateAddress(final Address address) {
        return addressDao.save(address);
    }

    @Override
    public void deleteAddress(final Address address) {
        addressDao.delete(address);
    }
}
