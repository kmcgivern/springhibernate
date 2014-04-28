package uk.co.kstech.rest.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uk.co.kstech.adapter.address.AddressAdapter;
import uk.co.kstech.dto.address.AddressDTO;
import uk.co.kstech.model.address.Address;

import java.util.List;

/**
 * Created by KMcGivern on 24/04/2014.
 */
@Controller
@RequestMapping("/addresses")
public class RestAddressService implements AddressService {

    @Autowired
    private AddressAdapter addressAdapter;

    @Autowired
    private uk.co.kstech.service.AddressService addressService;

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    AddressDTO getAddress(@RequestParam(value = "Id", required = true) final long Id) {
        final Address address = addressService.getAddress(Id);
        return addressAdapter.toAddressDTO(address);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = "application/json")
    public
    @ResponseBody
    List<AddressDTO> getAddresses() {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    AddressDTO createAddress(@RequestBody(required = true) final AddressDTO addressDTO) {
        return createOrUpdateAddressDTO(addressDTO);
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    public
    @ResponseBody
    AddressDTO updateAddress(@RequestBody(required = true) final AddressDTO addressDTO) {
        return createOrUpdateAddressDTO(addressDTO);
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAddress(@RequestBody(required = true) final long Id) {

    }

    private AddressDTO createOrUpdateAddressDTO(final AddressDTO addressDTO) {
        final Address address = addressAdapter.toAddress(addressDTO);
        addressService.createAddress(address);
        return addressAdapter.toAddressDTO(address);
    }
}
