package com.stock.gateway.repos;

import com.stock.gateway.models.JwtToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtTokenRepo extends JpaRepository<JwtToken, String> {
}
