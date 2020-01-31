package ua.kiev.tinedel.basic.spring.wagerledger.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.kiev.tinedel.basic.spring.wagerledger.models.Game;
import ua.kiev.tinedel.basic.spring.wagerledger.repositories.GameRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@AllArgsConstructor
public class GameController {

    private GameRepository gameRepository;

    @GetMapping(value = "/game")
    public List<Game> getGames() {
        return StreamSupport.stream(gameRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @GetMapping(value = "/game/{id}")
    public Optional<Game> getGame(@PathVariable("id") int id) {
        return gameRepository.findById(id);
    }

    @PostMapping(value = "/game", consumes = "application/json")
    public Game addGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

}
