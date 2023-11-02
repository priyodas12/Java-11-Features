package io.priyotech;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpClientAPIAsyncImpl {
    static final String endPoint="http://www.boredapi.com/api/activity?participants=222";

    public static void main(String[] args) {
        CompletableFuture<HttpResponse<String>> futureResponse = null;

        HttpClient httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(3))
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(endPoint))
                .GET()
                .build();

        futureResponse = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        futureResponse.thenApply(HttpResponse::body)
                .exceptionally(ex -> "Something wend wrong while fetching response from boredAPI: "+ex.getMessage())
                .thenAccept(System.out::println);

        futureResponse.join();//main thread wait for the result.

    }
}
