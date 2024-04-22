package Business.Entities;

public class User {

    private final int id;
    private final String email;
    private final String username;
    private final String password;
    private boolean connected;

    private boolean partidaActiva;

    /**
     * constructor of the class User, it contains the credentials of the people who uses the program
     *
     * @param id       integer that contains the number that identifies the user in the database
     * @param email    string that contains the mail address of the user
     * @param username is a string that allows us to identify a user
     * @param password used to prove who you are when connecting to database
     */
    public User(int id, String username, String email, String password, boolean connected) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.connected = connected;
        this.partidaActiva = false;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public boolean isPartidaActiva() {
        return partidaActiva;
    }

    public void setPartidaActiva(boolean partidaActiva) {
        this.partidaActiva = partidaActiva;
    }
}