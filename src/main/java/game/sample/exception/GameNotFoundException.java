package game.sample.exception;

/**
 * Exception thrown when a requested game is not found.
 */
public class GameNotFoundException extends RuntimeException {
    
    /**
     * Constructs a new GameNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public GameNotFoundException(String message) {
        super(message);
    }
}
