package com.pizzaportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatePortalApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer-route", GatePortalApplication::customerUri)
                .route("customer-multi-route", GatePortalApplication::customerMultiUri)
                .route("orderRoute", GatePortalApplication::orderUri)
                .build();
    }

    private static Buildable<Route> orderUri(PredicateSpec r) {
        return r.path("/orders")
                .filters(f -> f.rewritePath("/orders", "/api/v1/orders"))
                .uri("lb://order-portal");
    }

    private static Buildable<Route> customerMultiUri(PredicateSpec r) {
        return r.path("/customers/**")
                .filters(f -> f.rewritePath("/customers/(?<seg>.*)", "/api/v1/customers/${seg}"))
                .uri("lb://customer-portal");
    }

    private static Buildable<Route> customerUri(PredicateSpec r) {
        return r.path("/customers")
                .filters(f -> f.rewritePath("/customers", "/api/v1/customers"))
                .uri("lb://customer-portal");
    }

}
