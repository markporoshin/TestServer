package database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Mark on 10.07.2017.
 */
public class DBProcessor {
    //pattern singleton
    private static Connection connection = null;

    public DBProcessor() throws SQLException{
        DriverManager.registerDriver(new FabricMySQLDriver());
    }

    public static Connection getConnection(String URL, String USERNAME, String PASSWORD) throws SQLException{
        if(connection != null)
            return connection;
        return (connection = DriverManager.getConnection(URL, USERNAME, PASSWORD));
    }

    public void dispose() throws SQLException{
        connection.close();
    }
}
