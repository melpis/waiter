package com.waiter.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class GatewayApplication {
    @RequestMapping("/error")
    public String hystrixfallback() {
        return "This is a fallback";
    }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {

        final String reservationCommandUrl = "http://waiter-waiter-reservation-with-events-source-svc.staging.svc.cluster.local:8010";
        final String reservationQueryUrl = "http://waiter-waiter-reservation-with-events-sink-svc.staging.svc.cluster.local:8011";
        final String storeUrl = "http://waiter-store-svc.staging.svc.cluster.local:8020";
        final String menuUrl = "http://waiter-menu-svc.staging.svc.cluster.local:8030";
        final String notificationUrl = "http://waiter-notification-svc.staging.svc.cluster.local:8050";
        final String botUrl = "http://waiter-bot-svc.staging.svc.cluster.local:8080";
        final String smsUrl = "http://waiter-sms-svc.staging.svc.cluster.local:8090";

        return builder.routes()
                .route("path_reservation_command", r -> r.path("/api/reservation/**").and().method(HttpMethod.POST).or()
                        .method(HttpMethod.DELETE).or()
                        .method(HttpMethod.PUT).filters(f -> {
                            f.stripPrefix(2);
                            return f.hystrix(config -> config.setName("slowcmd").setFallbackUri("forward:error"));
                        })
                        .uri(reservationCommandUrl))
                .route("path_reservation_query", r -> r.method(HttpMethod.GET).and()
                        .path("/api/reservation/**").filters(f -> f.stripPrefix(2))
                        .uri(reservationQueryUrl))
                .route("path_store", r -> r.path("/api/store/**").filters( f -> f.stripPrefix(2))
                        .uri(storeUrl))
                .route("path_menu", r -> r.path("/api/menu/**").filters( f -> f.stripPrefix(2))
                        .uri(menuUrl))
                .route("path_notification", r -> r.path("/api/notification/**").filters( f -> f.stripPrefix(2))
                        .uri(notificationUrl))
                .route("path_bot", r -> r.path("/api/bot/**").filters( f -> f.stripPrefix(2))
                        .uri(botUrl))
                .route("path_sms", r -> r.path("/api/sms/**").filters( f -> f.stripPrefix(2))
                        .uri(smsUrl))
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
