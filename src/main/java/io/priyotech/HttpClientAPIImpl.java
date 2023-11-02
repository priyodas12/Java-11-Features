package io.priyotech;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientAPIImpl {
    static final String endPoint = "http://www.boredapi.com/api/activity?participants=1";

    public static void main(String[] args) {
        HttpResponse<String> response = null;
        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(2))
                    .build();/**builder pattern in action*/

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(endPoint))
                    .GET()
                    .build();/**builder pattern in action*/

            /**BodyHandlers converts response into string*/
            response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                System.out.println(response.body());
            } else {
                System.out.println("No Response from boredApi...");
            }
        }
    }
}
