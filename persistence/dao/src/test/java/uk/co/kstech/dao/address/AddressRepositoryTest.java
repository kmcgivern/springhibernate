package uk.co.kstech.dao.address;

import org.hamcrest.core.IsEqual;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import uk.co.kstech.dao.JPAConfiguration;
import uk.co.kstech.model.address.Address;

import javax.validation.*;

import java.util.Set;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class AddressRepositoryTest {

    @Autowired
    private AddressDao classUnderTest;

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void databaseIsEmpty() throws Exception {
        long count = classUnderTest.count();
        assertThat(count, IsEqual.equalTo(0L));
    }

    @Test
    public void shouldSaveAddress() throws Exception {
        final Address saved = saveAddress();

        Assert.notNull(saved.getId());
    }

    @Test
    public void shouldRetrieveAddress() {
        final Address saved = classUnderTest.save(saveAddress());
        final Address loadedAddress = classUnderTest.findOne(saved.getId());
        Assert.notNull(loadedAddress.getId());
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotSaveAddressWithNullFirstLine(){
        final Address address = createAddress();
        address.setFirstLine(null);
        validate(address);
        classUnderTest.save(address);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldNotSaveAddressWithInvalidPostcode(){
        final Address address = createAddress();
        final String invalidPostCode = "AA2C 4FG";
        address.setPostCode(invalidPostCode);
        validate(address);
        classUnderTest.save(address);
    }

    private Address saveAddress() {
        final Address saved = classUnderTest.save(createAddress());
        return saved;
    }

    private void validate(final Address address) {
        Set<ConstraintViolation<Address>> constraintViolations = validator.validate( address );
        assertThat(constraintViolations.size(), IsEqual.equalTo(1));
    }

    private Address createAddress() {
        Address address = new Address();
        address.setFirstLine("1 New Street");
        address.setSecondLine("");
        address.setTown("Belfast");
        address.setPostCode("BT1 1AB");

        return address;
    }
}
