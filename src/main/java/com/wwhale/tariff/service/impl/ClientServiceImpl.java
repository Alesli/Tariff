package com.wwhale.tariff.service.impl;

import com.wwhale.tariff.dao.UserDao;
import com.wwhale.tariff.dao.UserDaoImpl;
import com.wwhale.tariff.entity.Client;
import com.wwhale.tariff.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<Client> findAll() {
        return userDao.findAll();
    }
}
