package com.wwhale.tariff.service.impl;

import com.wwhale.tariff.dao.ClientDao;
import com.wwhale.tariff.dao.impl.ClientDaoImpl;
import com.wwhale.tariff.entity.Client;
import com.wwhale.tariff.service.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao = new ClientDaoImpl();

    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }
}
