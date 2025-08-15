package com.sarvesh.datainsight.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContoller {
    @GetMapping
    public String test() {
        return "Hello from the backend";
    }
}
