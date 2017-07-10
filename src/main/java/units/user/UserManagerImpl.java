package units.user;

import database.Executor;

import java.sql.SQLException;

/**
 * Created by Mark on 10.07.2017.
 */
public class UserManagerImpl implements UserManager{
    Executor executor;
    public UserManagerImpl(String url, String username, String pass) throws SQLException{
        executor = new Executor(url, username, pass);
    }
    public UserImpl getUser(String login){
        String query = "select * from business.units where business.units.userName = \"" + login + "\";";
        try {
            return (UserImpl) executor.execQuery(query, new UserHandler());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addUser(String login, String pass, String mail, String powers){
        if(login.contains(";") || pass.contains(";") || mail.contains(";"))
            return false;

        String query = "insert into business.units (userName, userPass, userEmail, powers) values (\"" + login + "\", \"" + pass + "\", \"" + mail + "\", \"" + powers + "\");";
        try {
            if(getUser(login) == null) {
                executor.execUpdate(query);
                //System.out.println("инъекция выполнена: " + login + " " + pass);
                return true;
                            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean check(String login, String pass){
        UserImpl u;
        if( (u = getUser(login)) != null)
            return u.check(login, pass);
        return false;
    }
}
