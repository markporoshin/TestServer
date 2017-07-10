package units.user;

/**
 * Created by Mark on 10.07.2017.
 */
public class UserImpl implements User {
    private String login;
    private String pass;

    public UserImpl(String login, String pass){
        this.login = login;
        this.pass = pass;
    }

    public boolean check(String login, String pass){
        if(this.login.equals(login) &&
                this.pass.equals(pass))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "[ login: " + login + ", password: " + pass + " ]";
    }

    public String getLogin(){return this.login;}
}
