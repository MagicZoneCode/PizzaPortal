package com.discoveryspot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverySpotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverySpotApplication.class, args);
    }

}
