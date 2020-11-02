package ch.bfh.obelix;


import ch.bfh.obelix.camp.config.ServiceConfiguration;
import ch.bfh.obelix.camp.model.Hero;
import ch.bfh.obelix.camp.model.Party;
import ch.bfh.obelix.camp.repository.HeroRepository;
import ch.bfh.obelix.camp.service.HeroService;
import ch.bfh.obelix.camp.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public class HeroesApplication {

    private static final Logger log = LoggerFactory.getLogger(HeroesApplication.class);

    public static void main(String[] args) {

        /**
         * Setup Spring dependency injection
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfiguration.class);

        /**
         * Create some heroes
         */
        HeroService myHeroService = context.getBean(HeroService.class);
        Hero hero1 = myHeroService.createHero("Superman");
        PartyService myPartyService = context.getBean(PartyService.class);
        Party party1 = myPartyService.createParty("Justice League");
        log.info("Party with name " + party1.getName() + " got created!");

        myHeroService.createHero("Superman");
        myHeroService.createHero("Batman");
        myHeroService.createHero("Iron Man");

        HeroRepository repository = context.getBean(HeroRepository.class);
        List<Hero> heroesWithAtkOver50 = repository.findAllByAtkGreaterThan(50);
        log.info("Heroes with ATK over 50:\n");
        for(Hero hero: heroesWithAtkOver50) {
            log.info(hero.getName() + " ATK is " + hero.getAtk());
        }

        context.close();


    }


}
