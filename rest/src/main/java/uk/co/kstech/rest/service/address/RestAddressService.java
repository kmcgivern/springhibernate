package uk.co.kstech.rest.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import uk.co.kstech.adapter.address.AddressAdapter;
import uk.co.kstech.dto.address.AddressDTO;

/**
 * Created by KMcGivern on 24/04/2014.
 */
@Controller
@RequestMapping("/addressService")
public class RestAddressService implements AddressService {


    public RestAddressService() {
        System.out.println("============ RestAddressService ========================== ====================");
    }

    @Autowired
    private AddressAdapter addressAdapter;

    @Autowired
    private uk.co.kstech.service.AddressService addressService;

    @RequestMapping(method = RequestMethod.GET)
    @Override
    public
    @ResponseBody
    AddressDTO getAddress(@RequestParam(value = "Id", required = false) final long Id) {
        AddressDTO dto = new AddressDTO();
        dto.setFirstLine("1 New Street");
        dto.setSecondLine("");
        dto.setTown("Belfast");
        dto.setPostCode("BT1 1AB");
        dto.setId(1L);
        return dto;
    }
}
