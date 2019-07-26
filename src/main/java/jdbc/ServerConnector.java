package jdbc;

import java.sql.Connection;

/**
 * @author Скороход Олеся
 */
public class ServerConnector {

    private static ServerConnector instance;
    private Connection connection;

    private ServerConnector(Connection connection) {
        this.connection = connection;
    }

    public static ServerConnector getInstance(Connection connection) {
        if (connection != null) {
            instance = new ServerConnector(connection);
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
