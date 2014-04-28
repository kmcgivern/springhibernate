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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by KMcGivern on 28/04/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestRestConfig.class})
public class TestRestAddressService {

    //{"id":null,"firstLine":"4 New Street","secondLine":"","town":"Belfast","postCode":"BT1 1AB"}

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
    public void shouldCreateAddress() {
        AddressDTO dto = createAddressDTO();
        final Address address = convertAddressDTO(dto);
        when(addressAdapter.toAddress(dto)).thenReturn(address);
        when(addressAdapter.toAddressDTO(address)).thenReturn(dto);
        when(mockAddressService.createAddress(address)).thenReturn(address);

        classUnderTest.createAddress(dto);
        Mockito.validateMockitoUsage();
    }

    @Test
    public void shouldUpdateAddress() {
        AddressDTO dto = createAddressDTO();
        final Address address = convertAddressDTO(dto);
        when(addressAdapter.toAddress(dto)).thenReturn(address);
        when(addressAdapter.toAddressDTO(address)).thenReturn(dto);
        when(mockAddressService.createAddress(address)).thenReturn(address);

        classUnderTest.updateAddress(dto);
        Mockito.validateMockitoUsage();
    }

    @Test
    public void shouldGetAddress() {
        AddressDTO dto = createAddressDTO();
        final Address address = convertAddressDTO(dto);
        when(addressAdapter.toAddressDTO(address)).thenReturn(dto);
        when(mockAddressService.getAddress(1)).thenReturn(address);

        classUnderTest.createAddress(dto);
        Mockito.validateMockitoUsage();
    }

    @Test
    public void shouldGetAllAddresses() {
        AddressDTO dto = createAddressDTO();
        final Address address = convertAddressDTO(dto);
        final List<Address> addresses = new ArrayList<>();
        final List<AddressDTO> addressDTOs = new ArrayList<>();
        addressDTOs.add(dto);
        addresses.add(address);

        when(addressAdapter.toAddressDTO(addresses)).thenReturn(addressDTOs);
        when(mockAddressService.getAddress()).thenReturn(addresses);

        classUnderTest.createAddress(dto);
        Mockito.validateMockitoUsage();
    }

    @Test
    public void shouldDeleteAddress() {
        AddressDTO dto = createAddressDTO();
        final Address address = convertAddressDTO(dto);

        when(mockAddressService.getAddress(1L)).thenReturn(address);
        doNothing().when(mockAddressService).deleteAddress(address);

        classUnderTest.deleteAddress(1L);
        Mockito.validateMockitoUsage();
    }

    @Test(expected = RestAddressService.AddressNotFoundException.class)
    public void shouldThrowExceptionOnDeletionOfInvalidAddress() {

        when(mockAddressService.getAddress(1L)).thenReturn(null);

        classUnderTest.deleteAddress(1L);
        Mockito.validateMockitoUsage();
    }

    private AddressDTO createAddressDTO() {
        AddressDTO dto = new AddressDTO();
        dto.setFirstLine("1 New Street");
        dto.setSecondLine("");
        dto.setTown("Belfast");
        dto.setPostCode("BT1 1AB");
        return dto;
    }

    private Address convertAddressDTO(final AddressDTO dto) {
        final Address address = new Address();
        address.setFirstLine(dto.getFirstLine());
        address.setSecondLine(dto.getSecondLine());
        address.setPostCode(dto.getPostCode());
        address.setTown(dto.getTown());
        return address;
    }

}
