import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private static final Logger log = LoggerFactory.getLogger(GameController.class);

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public List<Game> getAllGames() {
        log.info("Retrieving all games");
        return gameService.getAllGames();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Game> getGameByName(@PathVariable String name) {
        log.info("Retrieving game with name: {}", name);
        try {
            Game game = gameService.getGameByName(name);
            return ResponseEntity.ok(game);
        } catch (GameNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Void> createGame(@RequestBody Game game) {
        log.info("Creating game: {}", game);
        gameService.createGame(game);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateGame(@RequestBody Game game) {
        log.info("Updating game: {}", game);
        gameService.updateGame(game);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteGame(@PathVariable String name) {
        log.info("Deleting game with name: {}", name);
        gameService.deleteGame(name);
        return ResponseEntity.noContent().build();
    }
}
