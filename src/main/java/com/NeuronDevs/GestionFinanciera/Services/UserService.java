package com.NeuronDevs.GestionFinanciera.Services;

import com.NeuronDevs.GestionFinanciera.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class UserService {

    private final ArrayList<User> userList;

    public UserService(ArrayList<User> userList) {
        this.userList = userList;
    }

    public String newUser(User user){
        userList.add(user);
        return "Se ha agregado el usuario correctamente";
    }
    public ArrayList<User> getUsers(){
        return  userList;
    }

}
