package units.user;

import database.Executor;

import java.sql.SQLException;

/**
 * Created by Mark on 11.07.2017.
 */
public interface UserManager {

    public UserImpl getUser(String login);

    public boolean addUser(String login, String pass, String mail, String powers);

    public boolean check(String login, String pass);
}
