package com.wwhale.tariff.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Class for reading data from a connection.property file when connecting to a database
 *
 * @author Alesia Skarakhod
 */
public class PropertyReader {

    public Properties getProperties(String fileName) {

        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("property/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
