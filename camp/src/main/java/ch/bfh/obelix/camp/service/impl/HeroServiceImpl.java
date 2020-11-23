package ch.bfh.obelix.camp.service.impl;

import ch.bfh.obelix.CampApplication;
import ch.bfh.obelix.camp.model.Hero;
import ch.bfh.obelix.camp.repository.HeroRepository;
import ch.bfh.obelix.camp.service.HeroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class HeroServiceImpl implements HeroService {

    @Autowired
    private HeroRepository repository;

    private static final Logger log = LoggerFactory.getLogger(CampApplication.class);

    public Hero createHero(String name) {
        Hero newHero = new Hero();
        newHero.setName(name);
        log.debug("Set new hero name to " + newHero.getName());
        newHero.setAtk(new Random().nextInt(100));
        log.debug("Set " + newHero.getName() + " ATK to " + newHero.getAtk());
        newHero.setDef(new Random().nextInt(100));
        log.debug("Set " + newHero.getName() + " DEF to " + newHero.getDef());
        newHero.setHp(100.00);
        String uuid = repository.save(newHero).getId();
        return repository.findById(uuid).get();
    }


}
