package ch.bfh.obelix.camp.controller;

import ch.bfh.obelix.camp.model.Hero;
import ch.bfh.obelix.camp.model.Party;
import ch.bfh.obelix.camp.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/party")
public class PartyController {

  @Autowired
  private PartyService partyService;

  @Autowired
  private RepositoryEntityLinks entityLinks;

  @GetMapping("/{name}")
  public @ResponseBody Party createParty(@PathVariable String name) {
    Party party = partyService.createParty(name);

    // HAL Browser
    party.add(linkTo(methodOn(PartyController.class).createParty(name)).withSelfRel());
    for (int i = 0; i < party.getMembers().size(); i++) {
      party.add(entityLinks.linkToItemResource(Hero.class, party.getMembers().get(i).getId()).withRel("hero" + i));
    }

    return party;
  }

}
