package com.generoso.ft.sd.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Client {

    private final HttpClient httpClient;

    public HttpResponse<String> execute(RequestTemplate requestTemplate) {
        var httpRequest = requestTemplate.newHttpRequest();
        try {
            return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
