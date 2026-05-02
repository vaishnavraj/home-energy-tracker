package com.test.usageservice.dto;

import com.test.usageservice.model.Device;
import lombok.Builder;

import java.util.List;

@Builder
public record UsageDto(
        Long userId,
        List<Device> devices
) {}
