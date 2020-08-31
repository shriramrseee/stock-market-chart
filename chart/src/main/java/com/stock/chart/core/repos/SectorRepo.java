package com.stock.chart.core.repos;

import com.stock.chart.core.entities.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectorRepo extends JpaRepository<Sector, Integer> {
    List<Sector> findByNameContainingIgnoreCase(String name);

}
