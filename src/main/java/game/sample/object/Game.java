package game.sample.object;

import java.util.Date;

public class Game {
    private String name;
    private Date creationDate;
    private boolean isActive;

    public Game(String name, Date creationDate, boolean isActive) {
        this.name = name;
        this.creationDate = creationDate;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", isActive=" + isActive +
                '}';
    }
}