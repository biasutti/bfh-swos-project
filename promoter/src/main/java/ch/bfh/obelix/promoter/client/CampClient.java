package ch.bfh.obelix.promoter.client;

import ch.bfh.obelix.promoter.model.Party;
import org.springframework.hateoas.EntityModel;

public interface CampClient {

  EntityModel<Party> createParty(String name);

}
