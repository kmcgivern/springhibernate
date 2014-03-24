package uk.co.kstech.dao.address;

import org.springframework.data.repository.CrudRepository;
import uk.co.kstech.model.address.Address;

/**
 * Created by Kieran on 23/03/2014.
 */
public interface AddressDao extends CrudRepository<Address, Long> {
}
