package com.test.insightservice.dto;

import lombok.Builder;

@Builder
public record InsightDto(
        Long userId,
        String tips,
        double energyUsage
) {
}
