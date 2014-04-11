package uk.co.kstech.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import uk.co.kstech.dao.JPAConfiguration;

/**
 * Created by KMcGivern on 10/04/2014.
 */
@Configuration
@Import({JPAConfiguration.class, ServiceConfiguration.class})
public class TestServiceConfiguration {

//    @Bean
//    public AddressDao getAddressDao(){
//        return Mockito.mock(AddressDao.class);
//    }


//    @Bean
//    public PlatformTransactionManager transactionManager() throws SQLException {
//
//        JpaTransactionManager txManager = new JpaTransactionManager();
//        return txManager;
//    }
}


