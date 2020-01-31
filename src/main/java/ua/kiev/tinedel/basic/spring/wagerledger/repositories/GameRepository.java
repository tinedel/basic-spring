package ua.kiev.tinedel.basic.spring.wagerledger.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.tinedel.basic.spring.wagerledger.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Integer> {
}
