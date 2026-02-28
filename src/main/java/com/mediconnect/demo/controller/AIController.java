package com.mediconnect.demo.controller;

import com.mediconnect.demo.services.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AIController {

    private final GeminiService geminiService;

    // ✅ Accept JSON (text only)
    @PostMapping(value = "/chat", consumes = "application/json")
    public ResponseEntity<String> chatJson(
            @RequestBody Map<String, String> body) {

        String message = body.get("message");
        String response = geminiService.getAIResponse(message, null);
        return ResponseEntity.ok(response);
    }

    // ✅ Accept multipart (image or text+image)
    @PostMapping(value = "/chat", consumes = "multipart/form-data")
    public ResponseEntity<String> chatMultipart(
            @RequestParam(required = false) String message,
            @RequestParam(required = false) MultipartFile image) {

        String response = geminiService.getAIResponse(message, image);
        return ResponseEntity.ok(response);
    }
}