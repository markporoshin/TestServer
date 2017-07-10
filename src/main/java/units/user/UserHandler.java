package units.user;

import database.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mark on 10.07.2017.
 */
public class UserHandler implements ResultHandler {
    public UserImpl handle(ResultSet resultSet) throws SQLException {
        String login = null,
                pass = null,
                powers;
        while(resultSet.next()){
            login = resultSet.getString("userName");
            pass = resultSet.getString("userPass");
            powers = resultSet.getString("powers");
        }
        if(login != null && pass != null)
            return new UserImpl(login, pass);
        return null;
    }
}
