package com.stock.chart.user.repos;


import com.stock.chart.user.entities.Token;
import com.stock.chart.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Long> {
    Optional<Token> findTokenByToken(String token);
    Optional<Token> findTokenByUser(User user);
}

