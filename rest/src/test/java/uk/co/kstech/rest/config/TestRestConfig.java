package uk.co.kstech.rest.config;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;
import uk.co.kstech.adapter.address.AddressAdapter;
import uk.co.kstech.dto.address.AddressDTO;
import uk.co.kstech.rest.entry.Application;
import uk.co.kstech.rest.service.address.RestAddressService;
import uk.co.kstech.service.AddressService;

/**
 * Created by KMcGivern on 28/04/2014.
 */
@Configuration
@ComponentScan(basePackages = { "uk.co.kstech.rest.service.address.*"})
public class TestRestConfig {

    @Bean
    public uk.co.kstech.rest.service.address.AddressService getRestAddressService(){
        return new RestAddressService();
    }
    @Bean
    public AddressService getAddressService() {
        return Mockito.mock(AddressService.class);
    }

    @Bean
    public AddressAdapter getAddressAdapter() {
        return Mockito.mock(AddressAdapter.class);
    }


}


