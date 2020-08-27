package com.stock.chart.sector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("sector.properties")
public class SectorApp {

    public static void main(String[] args) {
        SpringApplication.run(SectorApp.class, args);
    }

}
