package uk.co.kstech.dao.address;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Kieran on 23/03/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"daos.xml"})
public class TestHibernateAddressDao {

    @Autowired
    private AddressDao classUnderTest;

    @Test
    public void shouldRunOk(){

    }
}
