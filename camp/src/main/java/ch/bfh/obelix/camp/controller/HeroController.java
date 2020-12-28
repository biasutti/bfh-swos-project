package ch.bfh.obelix.camp.controller;

import ch.bfh.obelix.camp.model.Hero;
import ch.bfh.obelix.camp.repository.HeroRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/heroes")
public class HeroController {

  @Autowired
  private HeroRepository heroRepository;

  @Autowired
  private RepositoryEntityLinks entityLinks;

  @GetMapping
  public @ResponseBody
  Iterable<Hero> list() {
    Iterable<Hero> heroes = heroRepository.findAll();

    // HAL Browser
    heroes.forEach(hero -> {
      hero.add(linkTo(methodOn(HeroController.class).list()).withSelfRel());
      hero.add(entityLinks.linkToItemResource(Hero.class, hero.getId()));
    });

    return heroes;
  }

  @GetMapping("/{id}")
  public @ResponseBody
  Hero getById(@PathVariable String id) {
    Hero hero = heroRepository.findById(id).get();

    // HAL Browser
    hero.add(linkTo(methodOn(HeroController.class).getById(id)).withSelfRel());

    return hero;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void createHero(@RequestBody Hero hero) {
    if (hero.getId() != null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hero must not have an id");
    }
    heroRepository.save(hero);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable String id, @RequestBody Hero hero) throws NotFoundException {
    if (hero.getId() == null || !hero.getId().equals(id)) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hero with missing or wrong id");
    }
    if (!heroRepository.existsById(id)) {
      throw new NotFoundException("Hero with id " + id + " not found");
    }
    heroRepository.save(hero);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public void delete(@PathVariable String id) {
    // TODO: Handel EmptyResultDataAccessException
    heroRepository.deleteById(id);
  }

}
