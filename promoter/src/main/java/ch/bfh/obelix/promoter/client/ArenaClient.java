package ch.bfh.obelix.promoter.client;


import ch.bfh.obelix.promoter.model.Party;

import java.util.List;

public interface ArenaClient {

  String battle(List<Party> challengers);

}
