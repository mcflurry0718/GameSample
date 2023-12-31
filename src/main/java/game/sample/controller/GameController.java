package game.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import game.sample.exception.GameNotFoundException;
import game.sample.object.Game;
import game.sample.service.GameService;

import java.util.List;

/**
 * REST controller for managing games.
 */
@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService gameService;

/**
 * Returns a list of all games.
 *
 * @return a list of all games
 */
    @GetMapping
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

/**
 * Returns the game with the specified name.
 *
 * @param name the name of the game to retrieve
 * @return the game with the specified name
 * @throws GameNotFoundException if no game with the specified name is found
 */
    @GetMapping("/{name}")
    public Game getGameByName(@PathVariable String name) throws GameNotFoundException {
        return gameService.getGameByName(name);
    }

/**
 * Creates a new game.
 *
 * @param game the game to create
 * @return the created game
 */
    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody Game game) {
        gameService.createGame(game);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

/**
 * Updates an existing game.
 *
 * @param game the game to update
 * @throws GameNotFoundException if no game with the specified name is found
 */
    @PutMapping("/{name}")
    public void updateGame(@RequestBody Game game) throws GameNotFoundException {
        gameService.updateGame(game);
    }

/**
 * Deletes the game with the specified name.
 *
 * @param name the name of the game to delete
 * @return an empty response with HTTP status 204 (No Content)
 * @throws GameNotFoundException if no game with the specified name is found
 */
    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteGame(@PathVariable String name) throws GameNotFoundException {
        gameService.deleteGame(name);
        return ResponseEntity.noContent().build();
    }

/**
 * Sets the game service to use for managing games.
 *
 * @param gameService the game service to use
 */
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
