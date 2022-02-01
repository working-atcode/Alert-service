package practice.demo.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class PushNotification {

    public String sendMessage(String phone_number, String message) {

//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .uri(URI.create("https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f"))
//                .build();
//        }
//
//        HttpClient httpClient = HttpClient.newBuilder()
//                .build()
        someService.sendMessageFromSMS();

    }
}
