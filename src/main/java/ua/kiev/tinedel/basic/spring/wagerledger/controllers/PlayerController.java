package ua.kiev.tinedel.basic.spring.wagerledger.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.kiev.tinedel.basic.spring.wagerledger.models.Player;
import ua.kiev.tinedel.basic.spring.wagerledger.models.Wager;
import ua.kiev.tinedel.basic.spring.wagerledger.repositories.PlayerRepository;
import ua.kiev.tinedel.basic.spring.wagerledger.repositories.WagerRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class PlayerController {

    private PlayerRepository playerRepository;
    private WagerRepository wagerRepository;

    @GetMapping(value = "/player")
    @ResponseBody
    public List<Player> getPlayers() {
        return StreamSupport.stream(playerRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping(value = "/player/{id}")
    @ResponseBody
    public Optional<Player> getPlayer(@PathVariable("id") int id) {
        return playerRepository.findById(id);
    }

    @PostMapping(value = "/player", consumes = "application/json")
    @ResponseBody
    public Player addPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @GetMapping("/player/{id}/won")
    @Transactional
    public int wonAmount(@PathVariable("id") int playerId) {
        return wagerRepository.findByPlayerIdAndWinning(playerId, true).mapToInt(Wager::getMoney).sum();
    }

    @GetMapping("/player/{id}/waged")
    @Transactional
    public int wagedAmount(@PathVariable("id") int playerId) {
        return wagerRepository.findByPlayerIdAndWinning(playerId, null).mapToInt(Wager::getMoney).sum();
    }

    @GetMapping("/player/{id}/wagesCount")
    @Transactional
    public long wagesCount(@PathVariable("id") int playerId) {
        return wagerRepository.findByPlayerId(playerId).count();
    }
}
