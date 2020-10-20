package ch.bfh.obelix.heroes;


import ch.bfh.obelix.heroes.model.Hero;
import ch.bfh.obelix.heroes.model.Party;
import ch.bfh.obelix.heroes.service.HeroServiceImpl;
import ch.bfh.obelix.heroes.service.PartyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class HeroesApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ch.bfh.obelix.heroes.service");
        context.refresh();
        HeroServiceImpl myHeroService = new HeroServiceImpl();
        Hero hero1 = myHeroService.createHero("Superman");
        printHeroData(hero1);
        PartyService myPartyService = context.getBean(PartyService.class);
        Party party1 = myPartyService.createParty("Justice League");
        System.out.println("Party with Name "+party1.getName()+" was created. Listing Members:");
        for (Hero member : party1.getMembers() ) {
            printHeroData(member);
        }

        context.close();

    }


    private static void printHeroData(Hero hero){
        System.out.println("Hero Name "+hero.getName());
        System.out.println("Hero Atk "+hero.getAtk());
        System.out.println("Hero Def "+hero.getDef());
        System.out.println("Hero HP "+hero.getHp());
    }

}
