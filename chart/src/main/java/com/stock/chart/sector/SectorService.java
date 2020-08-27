package com.stock.chart.sector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("sector.properties")
public class SectorService {

    public static void main(String[] args) {
        SpringApplication.run(SectorService.class, args);
    }

}
