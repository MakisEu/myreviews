package api;

import java.io.Serializable;

public class Registration implements Serializable {

    /**All the variables in the Registration class:
     * Username    The username of a User/Provider
     * Password    The password of a User/Provider
     * Name        The name of a User/Provider
     * Surname     The surname of a User/Provider
     * user_type   The user type (User or Provider)
     */
    private String Username;
    private final String Password;
    private String Name;
    private final String Surname;
    private final String user_type;

    /**
     * Normal constructor:
     * @param username  The username
     * @param password  The password
     * @param name      The name
     * @param surname   The surname
     * @param type      The type of user
     */
    public Registration(String username, String password, String name, String surname, String type) {
        Username = username;
        Password = password;
        Name = name;
        Surname = surname;
        user_type = type;
    }

    /**
     * Getter for the type of user
     * @return the type of the user
     */
    public String getUserType() {
        return user_type;
    }

    /**
     * Getter for the Username
     * @return The username
     */
    public String getUsername() {
        return this.Username;
    }

    /**
     * Setter for the Username
     * @param username The new username
     */
    public void setUsername(String username) {
        Username = username;
    }

    /**
     * Getter for the Surname
     * @return The Surname
     */
    public String getSurname() {
        return Surname;
    }

    /**
     * Getter for the password
     * @return The password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Getter for the name
     * @return The name
     */
    public String getName() {
        return Name;
    }

    /**
     * Setter for the name
     * @param name The name
     */
    public void setName(String name) {
        Name = name;
    }
}






