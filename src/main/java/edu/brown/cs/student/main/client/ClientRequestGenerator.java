package edu.brown.cs.student.main.client;

import edu.brown.cs.student.main.client.ClientAuth;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.net.http.HttpClient;

/**
 * This class generates the HttpRequests that are then used to make requests from the ApiClient.
 */
public class ClientRequestGenerator {
    /**
     * Generic secure request generator
     *
     * @return an HttpRequest object for accessing the secured resource.
     */
    public static HttpRequest secureRequest(String filepath) {
        ClientAuth clientAuth = new ClientAuth();
        String apiKey = clientAuth.getApiKey();
        String[] apiKeyArray = apiKey.split(" ");
        String user = apiKeyArray[0];
        String password = apiKeyArray[1];
        String reqUri = filepath + user + "&key= " + password;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqUri))
                .build();
        return request;
    }


}
