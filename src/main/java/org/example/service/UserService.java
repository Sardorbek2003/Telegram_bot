package org.example.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.example.model.User;
import org.example.util.FilePathUtil;
import org.example.util.JsonUtil;

import java.util.List;
import java.util.UUID;

public class UserService {


    public User add(User user) {
        List<User> users = read();
        if (!hasUser(users, user)) {
            users.add(user);
            write(users);
            return user;
        }
        throw new RuntimeException("This user already exists");
    }

    private boolean hasUser(List<User> users, User user) {
        return users.stream()
                .anyMatch(u -> u.getPhoneNumber().equals(user.getPhoneNumber()));
    }


    public User get(UUID id) {
        List<User> users = read();
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such user, found "));
    }


    public void delete(UUID id) {
        List<User> users = read();
        users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .ifPresent(users::remove);
        write(users);
    }


    public List<User> list() {
        return read();
    }

    private List<User> read() {
        return JsonUtil.readGson(FilePathUtil.getUser(), new TypeReference<>() {
        });
    }

    private void write(List<User> users) {
        JsonUtil.writeGson(users,FilePathUtil.getUser());
    }
}
