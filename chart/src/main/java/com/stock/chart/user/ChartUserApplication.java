package com.stock.chart.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ChartUserApplication {

    public static void main(String[] args) {
        SpringApplication springApp = new SpringApplication(ChartUserApplication.class);
        springApp.setAdditionalProfiles("user");
        springApp.run(args);
    }

}
