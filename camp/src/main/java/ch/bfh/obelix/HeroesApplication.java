package ch.bfh.obelix;


import ch.bfh.obelix.camp.model.Hero;
import ch.bfh.obelix.camp.model.Party;
import ch.bfh.obelix.camp.service.HeroService;
import ch.bfh.obelix.camp.service.HeroServiceImpl;
import ch.bfh.obelix.camp.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HeroesApplication {

    public static void main(String[] args) {

        /**
         * Setup Spring dependency injection
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ch.bfh.obelix.camp.service");
        context.refresh();

        /**
         * Create some heroes
         */
        HeroService myHeroService = context.getBean(HeroService.class);
        Hero hero1 = myHeroService.createHero("Superman");
        PartyService myPartyService = context.getBean(PartyService.class);
        Party party1 = myPartyService.createParty("Justice League");
        System.out.println("Party with Name " + party1.getName() + " was created. Listing Members:");


        context.close();

    }


}
