package ch.bfh.obelix.heroes;


import ch.bfh.obelix.heroes.model.Hero;
import ch.bfh.obelix.heroes.service.HeroServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HeroesApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HeroesApplication.class);
        
        HeroServiceImpl myHeroService = new HeroServiceImpl();
        Hero hero1 = myHeroService.createHero("Superman");
    }

}
