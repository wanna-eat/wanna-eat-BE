package com.wannaeat.global.config;

import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.stereotype.Component;

@Component
@EnableR2dbcAuditing
@EnableR2dbcRepositories
public class R2dbcConfig {
}
