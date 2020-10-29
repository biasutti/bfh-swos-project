package ch.bfh.obelix.camp.service;

import ch.bfh.obelix.camp.model.Hero;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService {

    public Hero createHero(String name) {
        Hero newHero = new Hero();
        newHero.setName(name);
        System.out.println("Set new hero name to " + newHero.getName());
        newHero.setAtk(new Random().nextInt(100));
        System.out.println("Set " + newHero.getName() + " ATK to " + newHero.getAtk());
        newHero.setDef(new Random().nextInt(100));
        System.out.println("Set " + newHero.getName() + " DEF to " + newHero.getDef());
        newHero.setHp(100.00);
        return newHero;
    }
}
