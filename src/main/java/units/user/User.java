package units.user;

/**
 * Created by Mark on 11.07.2017.
 */
public interface User {

    public boolean check(String login, String pass);

    public String toString();

    public String getLogin();
}
