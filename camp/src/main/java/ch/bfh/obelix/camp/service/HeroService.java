package ch.bfh.obelix.camp.service;

import ch.bfh.obelix.camp.model.Hero;

import java.util.List;

public interface HeroService {

    Hero createHero(String name);

    void saveHero(Hero hero);
    List<Hero> getAllHeroes();
    List<Hero> getHeroesAtkGreaterThan50();
}
