package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class GetApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetApiApplication.class, args);

        String url ="https://catfact.ninja/fact?max_lenght=140";      // my API call

        WebClient.Builder builder = WebClient.builder();

        String catFact = builder.build()
                .get().
                uri(url).
                retrieve()      // retrieving some data
                .bodyToMono(String.class)    // single noObject
                .block();

        System.out.println("----------------------------------------------------------");
        System.out.println(catFact);
        System.out.println("----------------------------------------------------------");

    }

}