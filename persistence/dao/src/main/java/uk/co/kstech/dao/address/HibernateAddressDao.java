package uk.co.kstech.dao.address;

import com.kstech.models.Address;
import org.springframework.stereotype.Repository;
import uk.co.kstech.dao.AbstractDao;

/**
 * Created by Kieran on 23/03/2014.
 */
@Repository
public class HibernateAddressDao extends AbstractDao<Address, Long> implements AddressDao {

    public HibernateAddressDao(Class<Address> classType) {
        super(classType);
    }
}
