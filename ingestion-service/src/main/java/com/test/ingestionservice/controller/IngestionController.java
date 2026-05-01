package com.test.ingestionservice.controller;

import com.test.ingestionservice.dto.EnergyUsageDto;
import com.test.ingestionservice.service.IngestionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingestion")
public class IngestionController {

    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService){
        this.ingestionService = ingestionService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void ingestData(@RequestBody EnergyUsageDto usageDto ){
        ingestionService.ingestEnergyUsage(usageDto);
    }

}
