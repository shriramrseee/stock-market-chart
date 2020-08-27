package com.stock.chart.repos;

import com.stock.chart.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepo extends JpaRepository<Sector, Integer> {
}
