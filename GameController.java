@RestController
@RequestMapping("/games")
public class GameController {
    
    @Autowired
    private GameService gameService;
    
     /**
     * Returns a list of all games.
     * 
     * @return a list of Game objects
     */
    @GetMapping("/")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }
    
    /**
     * Returns a game with the specified name.
     * 
     * @param name the name of the game to retrieve
     * @return a Game object with the specified name
     */
    @GetMapping("/{name}")
    public Game getGameByName(@PathVariable String name) {
        return gameService.getGameByName(name);
    }
    
    /**
     * Creates a new game.
     * 
     * @param game the game to create
     */
    @PostMapping("/")
    public void createGame(@RequestBody Game game) {
        gameService.createGame(game);
    }
    
     /**
     * Updates an existing game.
     * 
     * @param game the game to update
     */
    @PutMapping("/")
    public void updateGame(@RequestBody Game game) {
        gameService.updateGame(game);
    }
    
    /**
     * Deletes a game with the specified name.
     * 
     * @param name the name of the game to delete
     */
    @DeleteMapping("/{name}")
    public void deleteGame(@PathVariable String name) {
        gameService.deleteGame(name);
    }
    
}