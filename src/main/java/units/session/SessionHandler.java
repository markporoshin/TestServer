package units.session;

import database.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mark on 11.07.2017.
 */
public class SessionHandler implements ResultHandler {
    @Override
    public Session handle(ResultSet resultSet) throws SQLException {
        String session = null;
        String login = null;
        while(resultSet.next()){
            login  = resultSet.getString("");
            session = resultSet.getString("");
        }
        if(session != null && login != null)
            return new SessionImpl(session, login);
        return null;
    }
}
