package uk.co.kstech.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import uk.co.kstech.dao.address.AddressDao;
import uk.co.kstech.model.address.Address;
import uk.co.kstech.service.config.TestServiceConfiguration;

import static org.mockito.Mockito.when;

/**
 * Created by KMcGivern on 10/04/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestServiceConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AddressServiceTest {

    @InjectMocks
    @Autowired
    private AddressService classUnderTest;

    @Mock
    private AddressDao mockDao;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateAddress() {
        Address address = Mockito.mock(Address.class);
        when(mockDao.save(address)).thenReturn(address);
        classUnderTest.createAddress(address);
        Mockito.validateMockitoUsage();
    }

    @Test
    public void shouldUpdateAddress() {
        Address address = Mockito.mock(Address.class);
        when(mockDao.save(address)).thenReturn(address);
        classUnderTest.createAddress(address);
        Mockito.validateMockitoUsage();
    }

    @Test
    public void shouldAutowireOK() {
        Assert.assertNotNull(classUnderTest);
    }
}
