package com.wwhale.tariff.dao;

import com.wwhale.tariff.entity.Client;

import java.util.List;

public interface UserDao {

    List<Client> findAll();
}
