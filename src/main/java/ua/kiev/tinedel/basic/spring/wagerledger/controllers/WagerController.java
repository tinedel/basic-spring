package ua.kiev.tinedel.basic.spring.wagerledger.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.kiev.tinedel.basic.spring.wagerledger.models.*;
import ua.kiev.tinedel.basic.spring.wagerledger.repositories.GameRepository;
import ua.kiev.tinedel.basic.spring.wagerledger.repositories.PlayerRepository;
import ua.kiev.tinedel.basic.spring.wagerledger.repositories.WagerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class WagerController {
    
    private WagerRepository wagerRepository;
    private GameRepository gameRepository;
    private PlayerRepository playerRepository;

    @GetMapping(value = "/wager")
    @ResponseBody
    public List<Wager> getWagers() {
        return StreamSupport.stream(wagerRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping(value = "/wager/{id}")
    @ResponseBody
    public Optional<Wager> getWager(@PathVariable("id") int id) {
        return wagerRepository.findById(id);
    }

    @PostMapping(value = "/wager", consumes = "application/json")
    @ResponseBody
    public Wager addWager(@RequestBody WagerDto wagerDto) {
        Game game = gameRepository.findById(wagerDto.getGameId()).get();
        Player player = playerRepository.findById(wagerDto.getPlayerId()).get();
        Wager wager = new Wager(null, null, wagerDto.getMoney(), player, game);
        return wagerRepository.save(wager);
    }

}
