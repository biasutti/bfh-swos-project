package ch.bfh.obelix.promoter.service.impl;

import ch.bfh.obelix.promoter.client.ArenaClient;
import ch.bfh.obelix.promoter.client.CampClient;
import ch.bfh.obelix.promoter.model.Party;
import ch.bfh.obelix.promoter.service.PromoterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromoterServiceImpl implements PromoterService {

    private static final Logger LOG = LoggerFactory.getLogger(PromoterServiceImpl.class);

    @Autowired
    private CampClient campClient;

    @Autowired
    private ArenaClient arenaClient;

    @Override
    public String promoteFight() {

        Party challengee = campClient.createParty("Justice League").getContent();
        Party challenger = campClient.createParty("Avengers").getContent();
        LOG.info("Todays battle is between Party '"+challengee.getName()+"' and Party '"+challenger.getName()+"'.");

        List<Party> challangers = new ArrayList<>();
        challangers.add(challengee);
        challangers.add(challenger);
        String winner = arenaClient.battle(challangers);
        LOG.info("And the winner is: Party '"+winner+"'");

        return  winner;
    }
}
