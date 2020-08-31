package com.stock.chart.user.repos;


import com.stock.chart.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findUserByName(String name);
}

