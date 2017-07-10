package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.http.HttpServlet;
import java.net.ServerSocket;

/**
 * Created by Mark on 10.07.2017.
 */
public class ServerProcessor {
    Server server;
    ServletContextHandler context;

    public ServerProcessor() throws Exception{
        context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server = new Server(8080);
    }

    public void addServlet(HttpServlet servlet, String way){
        context.addServlet(new ServletHolder(servlet), way);
    }

    public void setContext(){
        server.setHandler(context);
    }

    public void start()throws Exception{
        server.start();
        server.join();
    }
}
