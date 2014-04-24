package uk.co.kstech.adapter.address;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.co.kstech.adapter.config.AdapterConfig;
import uk.co.kstech.service.AddressService;

/**
 * Created by KMcGivern on 24/04/2014.
 */
@Configuration
@Import({AdapterConfig.class})
public class TestAdapterConfig {

    @Bean
    public AddressService getAddressService() {
        return Mockito.mock(AddressService.class);
    }
}
