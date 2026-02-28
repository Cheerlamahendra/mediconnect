package com.mediconnect.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final WebClient webClient;

    public GeminiService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://generativelanguage.googleapis.com")
                .build();
    }

    public String getAIResponse(String prompt, MultipartFile image) {

        try {

            Map<String, Object> requestBody;

            // 🔥 If image is present
            if (image != null && !image.isEmpty()) {

                String base64Image = Base64.getEncoder()
                        .encodeToString(image.getBytes());

                requestBody = Map.of(
                        "contents", List.of(
                                Map.of(
                                        "parts", List.of(
                                                Map.of(
                                                        "text",
                                                        prompt != null && !prompt.isBlank()
                                                                ? prompt
                                                                : "Explain this image"
                                                ),
                                                Map.of(
                                                        "inlineData", Map.of(
                                                                "mimeType", image.getContentType(),
                                                                "data", base64Image
                                                        )
                                                )
                                        )
                                )
                        )
                );

            }
            // 🔥 Text only
            else {

                requestBody = Map.of(
                        "contents", List.of(
                                Map.of(
                                        "parts", List.of(
                                                Map.of("text", prompt)
                                        )
                                )
                        )
                );
            }

            return webClient.post()
                    .uri(uriBuilder -> uriBuilder
                            .path("/v1beta/models/gemini-2.5-flash:generateContent")
                            .queryParam("key", apiKey)
                            .build())
                    .bodyValue(requestBody)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .map(response -> {
                        List candidates = (List) response.get("candidates");

                        if (candidates == null || candidates.isEmpty()) {
                            return "No response from Gemini.";
                        }

                        Map candidate = (Map) candidates.get(0);
                        Map content = (Map) candidate.get("content");
                        List parts = (List) content.get("parts");
                        Map textPart = (Map) parts.get(0);

                        return textPart.get("text").toString();
                    })
                    .block();

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}