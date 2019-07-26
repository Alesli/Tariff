package service;

import entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    List<User> getBalanceById();
}
