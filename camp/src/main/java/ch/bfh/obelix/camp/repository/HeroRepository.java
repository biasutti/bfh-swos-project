package ch.bfh.obelix.camp.repository;

import ch.bfh.obelix.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {

}