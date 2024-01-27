package com.chat.aianswer.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class OpenAIService {

    @Value("${openai.apiKey}")
    private String apiKey;

    private static final String OPENAI_API_URL = "https://api.openai.com/v1/engines/davinci-codex/completions";

    public String generateResponse(String prompt) throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(OPENAI_API_URL);

        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + apiKey);

        // Customize the prompt and other parameters as needed
        String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 100}";

        httpPost.setEntity(new StringEntity(requestBody));

        HttpResponse response = httpClient.execute(httpPost);

        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder responseStringBuilder = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            responseStringBuilder.append(line);
        }

        return responseStringBuilder.toString();
    }
}

