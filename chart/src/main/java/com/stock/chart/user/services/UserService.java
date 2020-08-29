package com.stock.chart.user.services;

import com.stock.chart.user.entities.Token;
import com.stock.chart.user.entities.User;
import com.stock.chart.user.repos.TokenRepo;
import com.stock.chart.user.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

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

    public String loginUser(User user){
        Optional<User> u = userRepo.findUserByName(user.getName());
        if(u.isPresent() && u.get().getPassword().equals(user.getPassword())) {
            return tokenRepo.findTokenByUser(u.get()).get().getToken();
        } else {
            return "";
        }
    }

    public boolean checkToken(String token) {
        Optional<Token> t = tokenRepo.findTokenByToken(token);
        return t.isPresent();
    }



}
