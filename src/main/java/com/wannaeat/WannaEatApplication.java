package com.wannaeat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

@SpringBootApplication
public class WannaEatApplication {
    public static void main(String[] args) {
        SpringApplication.run(WannaEatApplication.class, args);
    }

}
