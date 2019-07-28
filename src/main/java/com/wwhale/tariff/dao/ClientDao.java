package com.wwhale.tariff.dao;

import com.wwhale.tariff.entity.Client;

import java.util.List;

public interface ClientDao {

    List<Client> findAll();
}
