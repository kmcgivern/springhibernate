package uk.co.kstech.service.config;

import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.co.kstech.dao.JPAConfiguration;
import uk.co.kstech.dao.address.AddressDao;
import uk.co.kstech.service.AddressService;
import uk.co.kstech.service.AddressServiceImpl;

/**
 * Created by KMcGivern on 10/04/2014.
 */
@Configuration
@Import({ServiceConfiguration.class})
@EnableAutoConfiguration
public class TestServiceConfiguration {

    @Bean
    public AddressDao getAddressDao() {

        return Mockito.mock(AddressDao.class);
    }

}


