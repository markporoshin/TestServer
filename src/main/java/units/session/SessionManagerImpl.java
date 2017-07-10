package units.session;

import database.Executor;

import java.sql.SQLException;

/**
 * Created by Mark on 11.07.2017.
 */
public class SessionManagerImpl implements SessionManager{
    Executor executor;

    public SessionManagerImpl(String url, String username, String password) throws SQLException {
        executor = new Executor(url, username, password);
    }

    public void addSession(String session) {

    }

    public void check(String session) {

    }

    public void deleteSession(String session) {

    }

    public void updateSession(String session, String nSession) {

    }
}
