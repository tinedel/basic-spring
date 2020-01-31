package ua.kiev.tinedel.basic.spring.wagerledger.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.kiev.tinedel.basic.spring.wagerledger.models.Wager;

import java.util.stream.Stream;

@Repository
public interface WagerRepository extends CrudRepository<Wager, Integer> {
    Stream<Wager> findByPlayerIdAndWinning(int playerId, Boolean winning);
    Stream<Wager> findByPlayerId(int playerId);
}
