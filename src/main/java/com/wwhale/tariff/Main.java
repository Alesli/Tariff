package com.wwhale.tariff;

import com.wwhale.tariff.entity.Client;
import com.wwhale.tariff.service.ClientService;
import com.wwhale.tariff.service.impl.ClientServiceImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClientService clientService = new ClientServiceImpl();
        List<Client> clientList = clientService.findAll();
//        for (Client user : clientList) {
//            System.out.println(user);
//        }
    }
}
