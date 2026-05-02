package com.test.usageservice.controller;

import com.test.usageservice.dto.UsageDto;
import com.test.usageservice.service.UsageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usage")
@RequiredArgsConstructor
public class UsageController {

    private final UsageService  usageService;

    @GetMapping("/{userId}")
    public ResponseEntity<UsageDto> getUsageDevice(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "3") int days
    ) {
        UsageDto usage = usageService.getXDaysUsageForUSer(userId, days);
        return ResponseEntity.ok(usage);
    }

}
