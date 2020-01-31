package ua.kiev.tinedel.basic.spring.wagerledger.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.tinedel.basic.spring.wagerledger.models.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
