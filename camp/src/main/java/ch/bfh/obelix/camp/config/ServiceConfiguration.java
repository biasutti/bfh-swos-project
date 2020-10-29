package ch.bfh.obelix.camp.config;

import ch.bfh.obelix.camp.service.HeroService;
import ch.bfh.obelix.camp.service.HeroServiceImpl;
import ch.bfh.obelix.camp.service.PartyService;
import ch.bfh.obelix.camp.service.PartyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public HeroService heroService() {
        return new HeroServiceImpl();
    }

    @Bean
    public PartyService partyService() {
        return new PartyServiceImpl();
    }
}
