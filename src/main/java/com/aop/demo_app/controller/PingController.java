package com.aop.demo_app.controller;

import com.aop.demo_app.dto.CommentResponse;
import com.aop.demo_app.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PingController {

    private final PingService pingService;

    @GetMapping("/ping")
    public ResponseEntity<CommentResponse> ping() {
        return ResponseEntity.ok(pingService.ping());
    }

}
