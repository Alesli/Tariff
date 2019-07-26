package dao;

import entity.User;
import jdbc.ServerConnector;
import jdbc.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс UserDao, получает данные из таблиц БД MySQL
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 * @author Alesia Skaraknoh
 */
public class UserDaoImpl implements UserDao {

    private Connection connection = ServerConnector.getInstance().getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * переопределеный метод, получает список пользователеей
     *
     * @return результат запроса getAllUser из файла mysql_queries.properties
     */
    @Override
    public List<User> findAll() {

        List<User> userList = new ArrayList<>();
        try {
            String query = ServerQuery.getInstance().getQuery("getAllUsers");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = getUser(resultSet);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return userList;
    }

    /**
     * переопределеный метод, получает список id/balance
     *
     * @return результат запроса getAllUser из файла mysql_queries.properties
     */
    @Override
    public List<User> findBalanceById() {
        List<User> userList = new ArrayList<>();
        try {
            String query = ServerQuery.getInstance().getQuery("getAllBalanceById");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setBalance(resultSet.getDouble(2));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return userList;
    }

    private User getUser(ResultSet resultSet) {
        try {
            User user = new User();
            user.setId(resultSet.getLong(1));
            user.setName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setTariff(resultSet.getString(4));
            user.setBalance(resultSet.getDouble(5));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void close(PreparedStatement preparedStatement, ResultSet resultSet) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
