package ch.bfh.obelix.camp.service.impl;

import ch.bfh.obelix.CampApplication;
import ch.bfh.obelix.camp.model.Hero;
import ch.bfh.obelix.camp.model.Party;
import ch.bfh.obelix.camp.service.HeroService;
import ch.bfh.obelix.camp.service.PartyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {

    private static final Logger log = LoggerFactory.getLogger(CampApplication.class);

    @Autowired
    private HeroService heroService;

    @Override
    public Party createParty(String name) {
        Party party = new Party();
        party.setName(name);
        log.info("Name of Party was set to " + name);
        List<Hero> members = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String memberName = "Hero" + i;
            Hero newMember = heroService.createHero(memberName);
            members.add(newMember);
            log.info("Hero with name " + memberName + " was added to Party " + name);
        }
        party.setMembers(members);
        return party;
    }
}
