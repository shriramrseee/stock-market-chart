package com.stock.gateway.repos;

import com.stock.gateway.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByName(String name);
}
