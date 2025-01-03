package com.wannaeat.wannaeat.infra.health;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HealthController {
    @GetMapping("/health")
    public String healthCheck() {
        return "hello:)";
    }
}
