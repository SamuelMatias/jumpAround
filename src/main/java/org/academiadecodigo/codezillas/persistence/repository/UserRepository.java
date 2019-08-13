package org.academiadecodigo.codezillas.persistence.repository;

import org.academiadecodigo.codezillas.persistence.model.User;

import java.util.HashMap;
@org.springframework.stereotype.Repository
public class UserRepository implements Repository<User>{

    private HashMap<Integer, User> usersDB;
    private int usersCounter;

    public User findById(Integer id) {
        if (userExist(id)){
            return usersDB.get(id);
        }
        //TODO:launch exception
        return null;
    }

    public void add(User user) {
        if (!userExist(user.getId())){
            usersCounter++;
            usersDB.put(usersCounter, user);
        }
        //TODO:launch exception
    }

    public void remove(User user) {
        if (userExist(user.getId())){
            usersDB.remove(user);
        }
        //TODO:launch exception
    }

    public void update(Integer id, User userUpdated) {
        if (userExist(id)){
            remove(findById(id));
            usersDB.put(id, userUpdated);
        }
        //TODO:launch exception
    }

    public boolean userExist(Integer id) {
        return usersDB.containsKey(id);
    }
}
