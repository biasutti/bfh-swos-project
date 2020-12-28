package ch.bfh.obelix.arena.service;

import ch.bfh.obelix.arena.model.Party;

public interface BattleService {

  String battle(Party party1, Party party2);

}
