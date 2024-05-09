package io.priyotech;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class HttpClientAPIImpl {

  private static final Logger logger = Logger.getLogger(HttpClientAPIImpl.class.getName());
  private static final String endPoint = "http://www.boredapi.com/api/activity?participants=1";

  public static void main(String[] args) {
    fetchApi();
  }

  private static void fetchApi() {
    HttpResponse<String> response = null;
    String responseBody = "";
    try {
      HttpClient httpClient = HttpClient.newBuilder()
          .connectTimeout(Duration.ofSeconds(1))
          .build(); /**builder pattern in action*/

      HttpRequest httpRequest = HttpRequest.newBuilder()
          .uri(URI.create(endPoint))
          .GET()
          .build(); /**builder pattern in action*/

      /**BodyHandlers converts response into string*/
      response = httpClient.send(httpRequest, BodyHandlers.ofString());
      responseBody = response.body();
    } catch (IOException | InterruptedException e) {
      logger.log(Level.INFO, e.getMessage());
      throw new RuntimeException(e);
    } finally {
      if (response.statusCode() == 200) {
        logger.log(Level.INFO, responseBody);
      } else {
        logger.info("No Response from boredApi...");
      }
    }
  }
}
