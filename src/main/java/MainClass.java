import server.ServerProcessor;
import server.servlets.AuthoServlet;
import units.user.UserManagerImpl;

/**
 * Created by Mark on 08.07.2017.
 */
public class MainClass {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "PoroshinMM";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] argv) throws Exception {
        UserManagerImpl um = new UserManagerImpl(URL, USERNAME, PASSWORD);
        ServerProcessor sp = new ServerProcessor();
        sp.addServlet(new AuthoServlet(um), "/autho");
        sp.setContext();
        sp.start();
    }
}
