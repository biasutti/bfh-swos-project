package ch.bfh.obelix.heroes.config;

import ch.bfh.obelix.heroes.service.HeroService;
import ch.bfh.obelix.heroes.service.HeroServiceImpl;
import ch.bfh.obelix.heroes.service.PartyService;
import ch.bfh.obelix.heroes.service.PartyServiceImpl;
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
