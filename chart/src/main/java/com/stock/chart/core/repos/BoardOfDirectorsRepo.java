package com.stock.chart.core.repos;

import com.stock.chart.core.entities.BoardOfDirectors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardOfDirectorsRepo extends JpaRepository<BoardOfDirectors, Integer> {
}
