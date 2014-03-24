package uk.co.kstech.dao.address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import uk.co.kstech.dao.JPAConfiguration;
import uk.co.kstech.model.address.Address;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AddressRepositoryTest {

    @Autowired
    private AddressDao classUnderTest;

    @Test
    public void databaseIsEmpty() throws Exception {
        long count = classUnderTest.count();
        assertEquals(0, count);
    }

    @Test
    public void saveAddress() throws Exception {
        Address address = new Address();
        address.setFirstLine("1 New Street");
        address.setSecondLine("");
        address.setTown("Belfast");
        address.setPostCode("BT11AB");

        final Address saved = classUnderTest.save(address);

        assertEquals(address, saved);
    }
}
