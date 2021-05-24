package main.model.entities;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author pablo
 */
public class ConnectionBD {
    private final String dbPort = "3306";
    private final String dbName = "taller3";
    private final String dbUser = "root";
    private final String dbPassword = "";
    private Connection connection;

    public Connection getConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:" + dbPort + "/" + dbName, dbUser, dbPassword);
        return connection;
    }
}
