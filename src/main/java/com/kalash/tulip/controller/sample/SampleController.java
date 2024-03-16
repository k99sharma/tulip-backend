package com.kalash.tulip.controller.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @GetMapping
    public String getSample(){
        return "Sample controller is working.";
    }
}
