package uk.co.kstech.adapter.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import uk.co.kstech.dto.address.AddressDTO;
import uk.co.kstech.model.address.Address;
import uk.co.kstech.service.AddressService;

/**
 * Created by KMcGivern on 24/04/2014.
 */
@Component
public class AddressAdapterImpl implements AddressAdapter {


    @Autowired
    private AddressService addressService;

    @Override
    public Address toAddress(final AddressDTO dto) {
        final Address address = getAddress(dto);
        address.setFirstLine(dto.getFirstLine());
        address.setSecondLine(dto.getSecondLine());
        address.setPostCode(dto.getPostCode());
        address.setTown(dto.getTown());
        return address;
    }

    @Override
    public AddressDTO toAddressDTO(final Address model) {
        final AddressDTO dto = new AddressDTO();
        dto.setTown(model.getTown());
        dto.setPostCode(model.getPostCode());
        dto.setFirstLine(model.getFirstLine());
        dto.setSecondLine(model.getSecondLine());
        dto.setId(model.getId());
        return dto;
    }

    private Address getAddress(final AddressDTO dto) {
        Address address = addressService.getAddress(dto.getId());
        if (address == null) {
            address = new Address();
        }
        return address;
    }
}
