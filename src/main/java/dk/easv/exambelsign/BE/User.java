package dk.easv.exambelsign.BE;

public class User {

    private String password;
    private String username;
    private int userID;
    private String role;
    private String firstName;
    private String lastName;



    public User(String password, String username, int userID, String role, String firstName, String lastName) {
        this.password = password;
        this.username = username;
        this.userID = userID;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getRole() {
        return this.role;
    }

    public String getFirstname() {
        return this.firstName;
    }

    public String getLastname() {
        return this.lastName;
    }
}
