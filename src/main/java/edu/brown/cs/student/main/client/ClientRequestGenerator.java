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
     * Similar to the introductory GET request, but restricted to api key holders only. Try calling it without the API
     * Key configured and see what happens!
     *
     * @return an HttpRequest object for accessing the secured resource.
     */
    public static HttpRequest getUsers() {
        String reqUri = "https://runwayapi.herokuapp.com/users-three";
        ClientAuth clientAuth = new ClientAuth();
        String apiKey = clientAuth.getApiKey();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqUri))
                .header("x-api-key", apiKey)
                .build();
        System.out.println(request);
        return request;
    }

    /**
     * Similar to the introductory GET request, but restricted to api key holders only. Try calling it without the API
     * Key configured and see what happens!
     *
     * @return an HttpRequest object for accessing the secured resource.
     */
    public static HttpRequest getReviews() {
        String reqUri = "https://runwayapi.herokuapp.com/reviews-five";
                ClientAuth clientAuth = new ClientAuth();
        String apiKey = clientAuth.getApiKey();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqUri))
                .header("x-api-key", apiKey)
                .build();
        System.out.println(request);
        return request;
    }

    /**
     * Similar to the introductory GET request, but restricted to api key holders only. Try calling it without the API
     * Key configured and see what happens!
     *
     * @return an HttpRequest object for accessing the secured resource.
     */
    public static HttpRequest getRent() {
        String reqUri = "https://runwayapi.herokuapp.com/rent-three";
                ClientAuth clientAuth = new ClientAuth();
        String apiKey = clientAuth.getApiKey();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(reqUri))
                .header("x-api-key", apiKey)
                .build();
        System.out.println(request);
        return request;
    }


//    /**
//     * This is another secured GET request that has an optional string parameter in the URL. Find out what the staff's
//     * horoscopes are!
//     *
//     * @param param - the name of the staff member whose horoscope you want to find; an empty string here will indicate
//     *              that the server should return a list of all staff members instead.
//     * @return an HttpRequest object for accessing and posting to the secured resource.
//     */
//    public static HttpRequest getHoroscopeGetRequest(String param) {
//        // Our taName parameter can either be empty, or some name, in which case it takes the format "?taName=name".
//        // If you tried this in the web browser URL you might see something like
//        // https://epb3u4xo11.execute-api.us-east-1.amazonaws.com/Prod/securedResource?taName=theInputName
//        ClientAuth clientAuth = new ClientAuth();
//        String apiKey = clientAuth.getApiKey();
//        String taName;
//        if (param.isEmpty()) {
//            taName = "";
//            String reqUri = "https://epb3u4xo11.execute-api.us-east-1.amazonaws.com/Prod/horoscopeResource/";
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(reqUri))
//                    .header("x-api-key", apiKey)
//                    .build();
//            System.out.println(request);
//            return request;
//        } else {
//            taName = "?taName=" + param;
//            String reqUri = "https://epb3u4xo11.execute-api.us-east-1.amazonaws.com/Prod/horoscopeResource/" + taName;
//            HttpRequest request = HttpRequest.newBuilder()
//                    .uri(URI.create(reqUri))
//                    .header("x-api-key", apiKey)
//                    .build();
//            System.out.println(request);
//            System.out.println("Getting star sign for " + param);
//            return request;
//        }
//    }
//}


}
