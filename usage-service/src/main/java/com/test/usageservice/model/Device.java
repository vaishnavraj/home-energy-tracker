package com.test.usageservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Device {
    private Long id;
    private String name;
    private String type;
    private String location;
    private Long userId;
    private Double energyConsumed;
}
