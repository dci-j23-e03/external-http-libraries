package com.dzenang;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

public class WebClientExample {

    public static void main(String[] args) {


    }

    public static void onlyBodyExample() {
        // creating a client
        WebClient webClient = WebClient.create("https://catfact.ninja");

        // building a request
        WebClient.ResponseSpec responseSpec = webClient.get().uri("/fact").retrieve();

        // specify future object to be populated when request executes
        Mono<String> bodyToMono = responseSpec.bodyToMono(String.class);

        // synchronous execution of the request
        String body = bodyToMono.block();
        System.out.println("Response body: " + body);
    }

    public static void statusAndBodyExample() {
        // creating a client
        WebClient webClient = WebClient.create("https://catfact.ninja");

        AtomicInteger responseCode = new AtomicInteger();
        // building a request
        Mono<String> response = webClient.get().uri("/fact").exchangeToMono(
                clientResponse -> {
                    if (clientResponse.statusCode().is2xxSuccessful()) {
                        responseCode.set(clientResponse.statusCode().value());
                        return clientResponse.bodyToMono(String.class);
                    }
                    return null;
                }
        );
        // synchronous execution of the request
        String body = response.block();
        System.out.println("Response code: " + responseCode.get());
        System.out.println("Response body: " + body);
    }
}
