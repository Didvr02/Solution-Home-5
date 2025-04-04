public class Agent {
    private String username;
    private boolean isLoggedIn;

    public Agent(String username, boolean isLoggedIn) {
        this.username = username;
        this.isLoggedIn = isLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }
}