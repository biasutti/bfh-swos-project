package ch.bfh.obelix.camp.repository;

import ch.bfh.obelix.camp.model.Hero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroRepository extends CrudRepository<Hero, String> {

    List<Hero> findByNameIgnoreCase(String name);

    List<Hero> findAllByAtkGreaterThan(int atk);

    //List<Hero> findAllOrOrderByAtk();

    //List<Hero> findAllOrOrderByDef();

    List<Hero> findByHpEquals(double hp);

}