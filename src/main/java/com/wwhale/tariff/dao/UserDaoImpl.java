package com.wwhale.tariff.dao;

import com.wwhale.tariff.entity.Client;
import com.wwhale.tariff.jdbc.ServerConnector;
import com.wwhale.tariff.jdbc.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * класс реализует интерфейс UserDao, получает данные из таблиц БД MySQL
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 * @author Alesia Skarakhod
 */
public class UserDaoImpl implements UserDao {

     private Connection connection = ServerConnector.getInstance(null).getConnection();
    private Map<String, String> queries = ServerQuery.getInstance(null).getQueries();

    /**
     * переопределеный метод, получает список пользователеей
     *
     * @return результат запроса getAllUser из файла mysql_queries.properties
     */
    @Override
    public List<Client> findAll() {

        List<Client> clientList = new ArrayList<>();
        try {
            String query = queries.get("getAllUsers");
            PreparedStatement userPreparedStatement = connection.prepareStatement(query);
            ResultSet userResultSet = userPreparedStatement.executeQuery();
            while (userResultSet.next()) {
                Client client = getUser(userResultSet);
                query = queries.get("getAllTariffsByUserId");
                PreparedStatement tariffPreparedStatement = connection.prepareStatement(query);
                tariffPreparedStatement.setLong(1, client.getId());
                ResultSet tariffResultSet = tariffPreparedStatement.executeQuery();
                List<Tariff> tariffList = getTariff(tariffResultSet);
                client.setTariffList(tariffList);
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientList;
    }

    private Client getUser(ResultSet resultSet) {
        try {
            return Client
                    .builder()
                    .id(resultSet.getLong(1))
                    .name(resultSet.getString(2))
                    .lastName(resultSet.getString(3))
                    .build();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Tariff> getTariff(ResultSet resultSet) {
        try {
            List<Tariff> tariffList = new ArrayList<>();
            while (resultSet.next()) {
                tariffList.add(
                        Tariff
                                .builder()
                                .id(resultSet.getLong(1))
                                .userId(resultSet.getLong(2))
                                .name(resultSet.getString(3))
                                .balance(resultSet.getDouble(4))
                                .build()
                );
            }
            return tariffList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
