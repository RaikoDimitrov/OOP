package Inheritance.hero;

public class Hero {
    private String username;
    private int level;

    public Hero(String username, int level) {
        this.setUsername(username);
        this.setLevel(level);
    }

    public String getUsername() {
        return username;
    }

    public int getLevel() {
        return level;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return String.format("Type: %s%n" + "Username: %s%n" + "Level: %s%n",
                this.getClass().getName(),
                this.getUsername(),
                this.getLevel());
    }
}
