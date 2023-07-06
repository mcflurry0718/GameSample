package game.sample.object;

import java.util.Date;

/**
 * Represents a game in the system.
 */
public class Game {
    private String name;
    private Date creationDate;
    private boolean isActive;

    /**
     * Constructs a new Game with the specified name, creation date, and active status.
     *
     * @param name the name of the game
     * @param creationDate the creation date of the game
     * @param isActive the active status of the game
     */
    public Game(String name, Date creationDate, boolean isActive) {
        this.name = name;
        this.creationDate = creationDate;
        this.isActive = isActive;
    }

    /**
     * Returns the name of the game.
     *
     * @return the name of the game
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the game.
     *
     * @param name the name of the game
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the creation date of the game.
     *
     * @return the creation date of the game
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the game.
     *
     * @param creationDate the creation date of the game
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Returns the active status of the game.
     *
     * @return the active status of the game
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets the active status of the game.
     *
     * @param isActive the active status of the game
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Returns a string representation of the game.
     *
     * @return a string representation of the game
     */
    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", isActive=" + isActive +
                '}';
    }
}
