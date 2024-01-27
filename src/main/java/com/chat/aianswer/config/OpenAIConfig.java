package com.chat.aianswer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAIConfig {

    @Value("${openai.apiKey}")
    private String apiKey;

    @Bean
    public String getApiKey() {
        return apiKey;
    }
}

