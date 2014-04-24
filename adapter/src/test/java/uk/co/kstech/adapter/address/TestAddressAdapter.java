package uk.co.kstech.adapter.address;

import org.hamcrest.Matchers;
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
import uk.co.kstech.dto.address.AddressDTO;
import uk.co.kstech.model.address.Address;
import uk.co.kstech.service.AddressService;

import static org.mockito.Mockito.when;

/**
 * Created by KMcGivern on 24/04/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAdapterConfig.class})
public class TestAddressAdapter {

    @InjectMocks
    @Autowired
    private AddressAdapter classUnderTest;

    @Mock
    private AddressService mockAddressService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCopyAddressToDTO() {
        Address model = createAddress();
        final AddressDTO dto = classUnderTest.toAddressDTO(model);
        Mockito.verifyZeroInteractions(mockAddressService);

        verifyFields(dto, model);
        Assert.assertEquals(model.getId(),new Long(dto.getId()));
    }

    @Test
    public void shouldCopyDTOToAddress() {
        AddressDTO dto = createAddressDTO();
        dto.setId(0L);
        when(mockAddressService.getAddress(dto.getId())).thenReturn(null);
        final Address model = classUnderTest.toAddress(dto);
        Mockito.validateMockitoUsage();
        verifyFields(dto, model);
        Assert.assertEquals(null, model.getId());
    }

    @Test
    public void shouldUpdateAddress(){
        AddressDTO dto = createAddressDTO();
        dto.setSecondLine("modified");

        Address originalFromDB = createAddress();

        when(mockAddressService.getAddress(dto.getId())).thenReturn(originalFromDB);
        final Address model = classUnderTest.toAddress(dto);
        verifyFields(dto, model);
    }

    private void verifyFields(final AddressDTO dto, final Address model) {
        Assert.assertThat(model.getFirstLine(), Matchers.equalToIgnoringWhiteSpace(dto.getFirstLine()));
        Assert.assertThat(model.getSecondLine(), Matchers.equalToIgnoringWhiteSpace(dto.getSecondLine()));
        Assert.assertThat(model.getTown(), Matchers.equalToIgnoringWhiteSpace(dto.getTown()));
        Assert.assertThat(model.getPostCode(), Matchers.equalToIgnoringWhiteSpace(dto.getPostCode()));

    }

    private Address createAddress() {
        Address address = new Address();
        address.setFirstLine("1 New Street");
        address.setSecondLine("");
        address.setTown("Belfast");
        address.setPostCode("BT1 1AB");
        address.setId(1L);
        return address;
    }

    private AddressDTO createAddressDTO() {
        AddressDTO dto = new AddressDTO();
        dto.setFirstLine("1 New Street");
        dto.setSecondLine("");
        dto.setTown("Belfast");
        dto.setPostCode("BT1 1AB");
        dto.setId(1L);
        return dto;
    }
}


