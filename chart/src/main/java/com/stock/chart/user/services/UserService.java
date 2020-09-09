package com.stock.chart.user.services;

import com.stock.chart.user.entities.Token;
import com.stock.chart.user.entities.User;
import com.stock.chart.user.repos.TokenRepo;
import com.stock.chart.user.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TokenRepo tokenRepo;

    public void addUser(User user){
        userRepo.save(user);
        Token t = new Token(user);
        tokenRepo.save(t);
    }

    public String[] loginUser(User user){
        Optional<User> u = userRepo.findUserByName(user.getName());
        String[] s = new String[2];
        if(u.isPresent() && u.get().getPassword().equals(user.getPassword())) {
            s[0] = u.get().getType();
            s[1] = tokenRepo.findTokenByUser(u.get()).get().getToken();
            return s;
        } else {
            s[0] = "";
            s[1] = "";
            return s;
        }
    }

    public boolean checkToken(String token) {
        Optional<Token> t = tokenRepo.findTokenByToken(token);
        return t.isPresent();
    }

    public void logoutUser(User user){
        Optional<User> u = userRepo.findUserByName(user.getName());
        if(u.isPresent() && u.get().getPassword().equals(user.getPassword())) {
            tokenRepo.deleteByUser(user);
        }
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

}
