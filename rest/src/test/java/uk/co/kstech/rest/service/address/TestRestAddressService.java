package uk.co.kstech.rest.service.address;

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
import uk.co.kstech.adapter.address.AddressAdapter;
import uk.co.kstech.dto.address.AddressDTO;
import uk.co.kstech.model.address.Address;
import uk.co.kstech.rest.config.TestRestConfig;
import uk.co.kstech.service.*;

import static org.mockito.Mockito.when;

/**
 * Created by KMcGivern on 28/04/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestRestConfig.class})
public class TestRestAddressService {

    @InjectMocks
    @Autowired
    private AddressService classUnderTest;

    @Mock
    private uk.co.kstech.service.AddressService mockAddressService;

    @Mock
    private AddressAdapter addressAdapter;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCreateAddress(){
        AddressDTO dto = createAddressDTO();
        final Address address = convertAddressDTO(dto);
        when(addressAdapter.toAddress(dto)).thenReturn(address);
        when(addressAdapter.toAddressDTO(address)).thenReturn(dto);
        when(mockAddressService.createAddress(address)).thenReturn(address);

        classUnderTest.createAddress(dto);

        Mockito.validateMockitoUsage();
    }

    private AddressDTO createAddressDTO(){
        AddressDTO dto = new AddressDTO();
        dto.setFirstLine("1 New Street");
        dto.setSecondLine("");
        dto.setTown("Belfast");
        dto.setPostCode("BT1 1AB");
        return dto;
    }

    private Address convertAddressDTO(final AddressDTO dto){
        final Address address = new Address();
        address.setFirstLine(dto.getFirstLine());
        address.setSecondLine(dto.getSecondLine());
        address.setPostCode(dto.getPostCode());
        address.setTown(dto.getTown());
        return address;
    }

}
