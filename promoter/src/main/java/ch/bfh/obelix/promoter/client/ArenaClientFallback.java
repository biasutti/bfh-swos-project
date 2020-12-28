package ch.bfh.obelix.promoter.client;

import ch.bfh.obelix.promoter.model.Party;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArenaClientFallback implements ArenaClient {

  @Override
  public String battle(List<Party> challengers) {
    return "The battle has to be postponed because the arena is occupied at the moment";
  }

}
