@RunWith(MockitoJUnitRunner.class)
public class GameIntegrationTest {
    
    @Mock
    private GameRepository gameRepository;
    
    @InjectMocks
    private GameServiceImpl gameService;
    
    @Test
    public void testGetAllGames() {
        // Create some test data
        List<Game> games = Arrays.asList(new Game("Game 1"), new Game("Game 2"));
        
        // Set up the mock to return the test data
        when(gameRepository.findAll()).thenReturn(games);
        
        // Call the getAllGames() method on the gameService
        List<Game> result = gameService.getAllGames();
        
        // Verify that the result matches the test data and the findAll() method was called on the mock GameRepository
        assertEquals(games, result);
        verify(gameRepository).findAll();
    }
    
    @Test
    public void testGetGameByName() {
        // Create some test data
        Game game = new Game("Game 1");
        
        // Set up the mock to return the test data
        when(gameRepository.findByName("Game 1")).thenReturn(Optional.of(game));
        
        // Call the getGameByName() method on the gameService
        Game result = gameService.getGameByName("Game 1");
        
        // Verify that the result matches the test data and the findByName() method was called on the mock GameRepository
        assertEquals(game, result);
        verify(gameRepository).findByName("Game 1");
    }
    
    @Test(expected = GameNotFoundException.class)
    public void testGetGameByNameNotFound() {
        // Set up the mock to return an empty Optional
        when(gameRepository.findByName("Game 1")).thenReturn(Optional.empty());
        
        // Call the getGameByName() method on the gameService and expect a GameNotFoundException to be thrown
        gameService.getGameByName("Game 1");
    }
    
    @Test
    public void testCreateGame() {
        // Create some test data
        Game game = new Game("Game 1");
        
        // Call the createGame() method on the gameService
        gameService.createGame(game);
        
        // Verify that the save() method was called on the mock GameRepository with the correct argument
        verify(gameRepository).save(game);
    }
    
    @Test
    public void testUpdateGame() {
        // Create some test data
        Game game = new Game("Game 1");
        
        // Set up the mock to return the test data
        when(gameRepository.save(game)).thenReturn(game);
        
        // Call the updateGame() method on the gameService
        gameService.updateGame(game);
        
        // Verify that the save() method was called on the mock GameRepository with the correct argument
        verify(gameRepository).save(game);
    }
    
    @Test
    public void testDeleteGame() {
        // Call the deleteGame() method on the gameService
        gameService.deleteGame("Game 1");
        
        // Verify that the deleteByName() method was called on the mock GameRepository with the correct argument
        verify(gameRepository).deleteByName("Game 1");
    }
    
    @Test
    public void testGetAllGamesController() {
        // Create a mock GameService
        GameService gameService = mock(GameService.class);
        
        // Create some test data
        List<Game> games = Arrays.asList(new Game("Game 1"), new Game("Game 2"));
        
        // Set up the mock to return the test data
        when(gameService.getAllGames()).thenReturn(games);
        
        // Create a new GameController instance and call the getAllGames() method
        GameController controller = new GameController();
        controller.setGameService(gameService);
        List<Game> result = controller.getAllGames();
        
        // Verify that the result matches the test data and the getAllGames() method was called on the mock GameService
        assertEquals(games, result);
        verify(gameService).getAllGames();
    }
    
    @Test
    public void testGetGameByNameController() {
        // Create a mock GameService
        GameService gameService = mock(GameService.class);
        
        // Create some test data
        Game game = new Game("Game 1");
        
        // Set up the mock to return the test data
        when(gameService.getGameByName("Game 1")).thenReturn(game);
        
        // Create a new GameController instance and call the getGameByName() method
        GameController controller = new GameController();
        controller.setGameService(gameService);
        Game result = controller.getGameByName("Game 1");
        
        // Verify that the result matches the test data and the getGameByName() method was called on the mock GameService
        assertEquals(game, result);
        verify(gameService).getGameByName("Game 1");
    }

    @Test
    public void testCreateGameController() {
        // Create a mock GameService
        GameService gameService = mock(GameService.class);
        
        // Create some test data
        Game game = new Game("Game 1");
        
        // Create a new GameController instance and call the createGame() method
        GameController controller = new GameController();
        controller.setGameService(gameService);
        controller.createGame(game);
        
        // Verify that the createGame() method was called on the mock GameService with the correct argument
        verify(gameService).createGame(game);
    }
    
    @Test
    public void testUpdateGameController() {
        // Create a mock GameService
        GameService gameService = mock(GameService.class);
        
        // Create some test data
        Game game = new Game("Game 1");
        
        // Create a new GameController instance and call the updateGame() method
        GameController controller = new GameController();
        controller.setGameService(gameService);
        controller.updateGame(game);
        
        // Verify that the updateGame() method was called on the mock GameService with the correct argument
        verify(gameService).updateGame(game);
    }
    
    @Test
    public void testDeleteGameController() {
        // Create a mock GameService
        GameService gameService = mock(GameService.class);
        
        // Create a new GameController instance and call the deleteGame() method
        GameController controller = new GameController();
        controller.setGameService(gameService);
        controller.deleteGame("Game 1");
        
        // Verify that the deleteGame() method was called on the mock GameService with the correct argument
        verify(gameService).deleteGame("Game 1");
    }
    
}