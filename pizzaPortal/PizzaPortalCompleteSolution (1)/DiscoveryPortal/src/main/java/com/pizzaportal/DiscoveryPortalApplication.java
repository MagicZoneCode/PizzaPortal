package com.pizzaportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryPortalApplication.class, args);
    }

}
