package com.stock.chart.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ChartCoreApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(ChartCoreApplication.class);
        springApp.setAdditionalProfiles("core");
        springApp.run(args);
    }

}
