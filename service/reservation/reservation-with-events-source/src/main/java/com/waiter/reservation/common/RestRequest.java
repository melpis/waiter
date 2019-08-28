package com.waiter.reservation.common;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class RestRequest {

    public Mono<ClientResponse> commonRestApiCall(String url, Object body, HttpMethod method, String cookie, String auth) {
        String bodyStr = null;
        if (body != null) {
            try {
                bodyStr = new ObjectMapper().writeValueAsString(body);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("object mapper obj to string error  ");
            }
        }
        return this.commonRestApiCall(url, bodyStr, method, cookie, auth);
    }

    private Mono<ClientResponse> commonRestApiCall(String url, String body, HttpMethod method, String cookie, String auth) {
        WebClient webClient = WebClient.builder().baseUrl(url).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
        if (auth != null) {
            headers.set("Authorization", auth);
        }

        if (cookie != null) {
            headers.set("Cookie", cookie);
        }

        log.info("request Url : " + url + ", method : " + method.toString());
        log.info("request body ");
        log.info(body);

        return webClient.method(method).headers(httpHeaders -> httpHeaders.addAll(headers)).body(BodyInserters
                .fromPublisher(Mono.just(body), String.class)).exchange();
    }

}
