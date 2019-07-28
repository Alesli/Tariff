package com.wwhale.tariff.dao.impl;

import com.wwhale.tariff.dao.ClientDao;
import com.wwhale.tariff.entity.Client;
import com.wwhale.tariff.jdbc.ServerConnector;
import com.wwhale.tariff.jdbc.ServerQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * класс реализует интерфейс ClientDao, получает данные из таблиц БД MySQL
 * через запросы из файла mysql_queries.properties с использованием JDBC.
 *
 * @author Alesia Skarakhod
 */
public class ClientDaoImpl implements ClientDao {

    private Connection connection = ServerConnector.getInstance().getConnection();
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    /**
     * переопределеный метод, получает список пользователеей
     *
     * @return результат запроса findAll из файла mysql_queries.properties
     */
    @Override
    public List<Client> findAll() {

        List<Client> clientList = new ArrayList<>();
        try {
            String query = ServerQuery.getInstance().getQuery("findAll");
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Client client = getUser(resultSet);
                clientList.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement, resultSet);
        }
        return clientList;
    }

    private Client getUser(ResultSet resultSet) {
        try {
            Client client = new Client();
            client.setId(resultSet.getLong(1));
            client.setName(resultSet.getString(2));
            client.setTariff(resultSet.getString(3));
            client.setBalance(resultSet.getDouble(4));
            return client;
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
