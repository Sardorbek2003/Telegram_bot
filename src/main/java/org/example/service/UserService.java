package org.example.service;

import org.example.contener.ComponentContainer;
import org.example.model.Category;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {

    private void add(User user){
        List<User> users = new ArrayList<>();
        users.add(user);
    }

}
