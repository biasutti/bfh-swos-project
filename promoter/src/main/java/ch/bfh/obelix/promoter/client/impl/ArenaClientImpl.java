package ch.bfh.obelix.promoter.client.impl;

import ch.bfh.obelix.promoter.client.ArenaClient;
import ch.bfh.obelix.promoter.model.Party;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ArenaClientImpl implements ArenaClient {

    @Override
    public String battle(List<Party> challengers) {
        ResponseEntity<String> response =  new RestTemplate().exchange(
                "http://localhost:3333/battle",
                HttpMethod.POST,
                new HttpEntity<>(challengers),
                String.class);
        return response.getBody();
    }
}
