package com.aop.demo_app.service.impl;

import com.aop.demo_app.dto.CommentResponse;
import com.aop.demo_app.service.PingService;
import org.springframework.stereotype.Service;

@Service
public class PingServiceImpl implements PingService {

    @Override
    public CommentResponse ping() {
        return CommentResponse.builder()
                .comment("pong")
                .build();
    }

}
