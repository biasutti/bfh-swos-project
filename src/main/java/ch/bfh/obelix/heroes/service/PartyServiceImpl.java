package ch.bfh.obelix.heroes.service;

import ch.bfh.obelix.heroes.model.Hero;
import ch.bfh.obelix.heroes.model.Party;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {


    @Autowired
    private HeroService heroService;

    @Override
    public Party createParty(String name) {
        Party myParty  =  new Party();
        myParty.setName(name);
        System.out.println("Name of Party was set to "+name);
        List<Hero> members = new ArrayList<>();

        for (int i=0;i<4;i++){
            String memberName = "Hero"+i;
            Hero newMember = heroService.createHero(memberName);
            members.add(newMember);
            System.out.println("Hero with name "+memberName+" was added to Party "+name);
        }
        myParty.setMembers(members);
        return myParty;
    }
}
