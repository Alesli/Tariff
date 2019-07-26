package util;

import java.io.IOException;
import java.util.Properties;

/**
 * класс, для чтения данных из файла connection.properties при подключении к БД
 *
 * @author Слижова Олеся
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
