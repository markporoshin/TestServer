package units.session;

/**
 * Created by Mark on 11.07.2017.
 */
public interface SessionManager {
    public void addSession(String  session);
    public void check(String session);
    public void deleteSession(String session);
    public void updateSession(String session, String nSession);
}
