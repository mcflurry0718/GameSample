/**
 * The GameService interface provides methods for retrieving, creating, updating, and deleting games.
 */
public interface GameService {
    
    /**
     * Retrieves all games.
     * @return a list of all games
     */
    List<Game> getAllGames();
    
    /**
     * Retrieves a game by its name.
     * @param name the name of the game to retrieve
     * @return the game with the specified name
     * @throws GameNotFoundException if no game is found with the given name
     */
    Game getGameByName(String name) throws GameNotFoundException;;
    
    /**
     * Creates a new game.
     * @param game the game to create
     */
    void createGame(Game game);
    
    /**
     * Updates an existing game.
     * @param game the game to update
     */
    void updateGame(Game game);
    
    /**
     * Deletes a game by its name.
     * @param name the name of the game to delete
     */
    void deleteGame(String name);
    
}