package com.test.usageservice.client;

import com.test.usageservice.dto.DeviceDto;
import com.test.usageservice.model.Device;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Component
public class DeviceClient {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public DeviceClient(@Value("${device.service.url}") String baseUrl) {
        this.baseUrl = baseUrl;
        this.restTemplate = new RestTemplate();
    }

    public DeviceDto getDeviceById(Long deviceId){
        String url = UriComponentsBuilder.fromUriString(baseUrl)
                .path("/{deviceId}")
                .buildAndExpand(deviceId)
                .toUriString();
        ResponseEntity<DeviceDto> responseEntity = restTemplate.getForEntity(url, DeviceDto.class);
        return responseEntity.getBody();
    }

    public List<Device> getAllDevicesForUser(Long userId) {
        String url = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/user/{userId}")
                .buildAndExpand(userId)
                .toUriString();

        ResponseEntity<Device[]> responseEntity = restTemplate.getForEntity(url, Device[].class);
        Device[] devices = responseEntity.getBody();
        return devices == null || devices.length <= 0? List.of():List.of(devices);
    }
}
