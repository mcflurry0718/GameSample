package game.sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import game.sample.exception.GameNotFoundException;
import game.sample.object.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
@Transactional
@CacheConfig(cacheNames = "games")
public class GameServiceImpl implements GameService {
    private static final Logger log = LoggerFactory.getLogger(GameServiceImpl.class);    

    // In-memory cache to store games
    private Map<String, Game> gameMap = new ConcurrentHashMap<String, Game>();
    
    /**
     * Retrieves all games.
     * @return a list of all games
     */
    @Override
    @Cacheable("games")
    public List<Game> getAllGames() {
        return new ArrayList<>(gameMap.values());
    }

    /**
     * Retrieves a game by its name.
     * @param name the name of the game to retrieve
     * @return the game with the specified name
     * @throws GameNotFoundException if no game is found with the given name
     */
    @Override
    @Cacheable(value = "games", key = "#name") 
    public Game getGameByName(String name) throws GameNotFoundException {
        log.info("Retrieving game with name: {}", name);
        Game game = gameMap.get(name);
        if (game == null) {
            throw new GameNotFoundException("Game not found with name: " + name);
        }
        return game;
    }
    
    /**
     * Creates a new game.
     * @param game the game to create
     */
    @Override
    @CachePut(value = "games", key = "#game.getName()")
    public void createGame(Game game) {
        gameMap.put(game.getName(), game);
        log.info("Created game: {}", game);
    }
    
    /**
     * Updates an existing game.
     * @param game the game to update
     */
    @Override
    @CachePut(value = "games", key = "#game.getName()")
    public void updateGame(Game game) {
        gameMap.put(game.getName(), game);
        log.info("Updated game: {}", game);
    }
    
    /**
     * Deletes a game by its name.
     * @param name the name of the game to delete
     */
    @Override
    @CacheEvict(key = "#name")
    public void deleteGame(String name) {
        gameMap.remove(name);
        log.info("Deleted game with name: {}", name);
    }
 }