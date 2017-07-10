package units.session;

/**
 * Created by Mark on 11.07.2017.
 */
public class SessionImpl implements Session{
    private String login;
    private String session;

    public SessionImpl(String login, String session){
        this.login = login;
        this.session = session;
    }

    public boolean check(String session) {
        if(this.session.equals(session))
            return true;
        return false;
    }
}
