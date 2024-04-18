package Business.Entities;

public class User {

    private final int id;
    private final String email;
    private final String username;
    private final String password;
    private final boolean connected;

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
    }

    /**
     * constructor of the class User, it contains the credentials of the people who uses the program
     *
     * @param username  is a string that allows us to identify a user
     * @param email     string that contains the mail address of the user
     * @param password  used to prove who you are when connecting to database
     * @param connected
     */
    public User(String username, String email, String password, boolean connected) {
        this.id = 0;
        this.email = email;
        this.username = username;
        this.password = password;
        this.connected = connected;
    }

    public String getPassword() {
        return password;
    }
}