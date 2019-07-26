import entity.User;
import jdbc.ServerConnector;
import jdbc.ServerQuery;
import service.UserService;
import service.impl.UserServiceImpl;
import util.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        PropertyReader propertyReader = new PropertyReader();
        Properties properties = propertyReader.getProperties("connection.properties");

        Connection connection = null;
        try {
            Class.forName(properties.getProperty("driver"));
            try {
                connection = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ServerConnector.getInstance(connection);


        String server = properties.getProperty("server");
        if (server.equalsIgnoreCase("mysql")) {
            properties = propertyReader.getProperties("mysql_queries.properties");
        }
        Map<String, String> map = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> prop : properties.entrySet()) {
            map.put(prop.getKey().toString(), prop.getValue().toString());
        }
        ServerQuery.getInstance(map);


        UserService userService = new UserServiceImpl();
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
