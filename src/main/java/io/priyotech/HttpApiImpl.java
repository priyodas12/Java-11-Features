package io.priyotech;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpApiImpl {
    static final String endPoint = "http://www.boredapi.com/api/activity?participants=1";

    public static void main(String[] args) {
        HttpResponse<String> response = null;
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(2))
                    .build();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(endPoint))
                    .GET()
                    .build();

            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                Gson gson = new Gson();
                System.out.println(gson.toJson(response.body()));
            } else {
                System.out.println("No Response from boredApi...");
            }
        }
    }
}
