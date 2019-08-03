package com.wwhale.tariff.jdbc;

import com.wwhale.tariff.util.PropertyReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * The class for establishing a connection with MySQL database
 *
 * @author Alesia Skarakhod
 */
public class ServerQuery {

    private static ServerQuery instance;
    private static Map<String, String> queries;

    /**
     * The method for connecting to the MySQL server by property
     * readable from the connection.property file
     */
    private ServerQuery() {

        PropertyReader propertyReader = new PropertyReader();
        Properties properties = propertyReader.getProperties("connection.properties");

        String server = properties.getProperty("server");

        if (server.equalsIgnoreCase("mysql")) {
            properties = propertyReader.getProperties("mysql_queries.properties");
        }

        Map<String, String> map = new HashMap<>(properties.size());
        for (Map.Entry<Object, Object> prop : properties.entrySet()) {
            map.put(prop.getKey().toString(), prop.getValue().toString());
        }
        queries = map;
    }

    /**
     * The static method, returns a single instance of the class,
     * checking whether it was not created before
     *
     * @return instance
     */
    public static ServerQuery getInstance() {
        if (instance == null) {
            instance = new ServerQuery();
        }
        return instance;
    }

    /**
     * the method will receive a request to the MySQL server
     * from the mysql_queries.property file by key
     *
     * @param key String, request name
     * @return queries.get(key)
     */
    public String getQuery(String key) {
        if (key != null) {
            return queries.get(key);
        } else {
            return "";
        }
    }
}
