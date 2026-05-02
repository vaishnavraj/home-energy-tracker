package com.test.deviceservice.service;

import com.test.deviceservice.dto.DeviceDto;
import com.test.deviceservice.entity.Device;
import com.test.deviceservice.exception.DeviceNotFoundException;
import com.test.deviceservice.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public DeviceDto getDeviceById(Long id) {
        Device device = deviceRepository.findById(id).orElseThrow(() ->
                new DeviceNotFoundException("Device not found with id "+id));
        return mapToDto(device);
    }



    public DeviceDto createDevice(DeviceDto input) {
        Device device = Device.builder()
                .name(input.getName())
                .type(input.getType())
                .location(input.getLocation())
                .userId(input.getUserId())
                .build();
        Device createdDevice = deviceRepository.save(device);
        return mapToDto(createdDevice);
    }

    public DeviceDto updateDevice(Long id, DeviceDto input) {
        Device existing = deviceRepository.findById(id)
                .orElseThrow(() -> new DeviceNotFoundException("Device not found with id "+id));
        existing.setName(input.getName());
        existing.setType(input.getType());
        existing.setLocation(input.getLocation());
        existing.setUserId(input.getUserId());
        final Device updatedDevice = deviceRepository.save(existing);
        return mapToDto(updatedDevice);
    }

    public void deleteDevice(Long id) {
        if(!deviceRepository.existsById(id)){
           throw new DeviceNotFoundException("Device not found with id "+id);
        }
        deviceRepository.deleteById(id);
    }

    public List<DeviceDto> getAllDevicesByUserId(Long userId) {
        List<Device> devices = deviceRepository.findAllByUserId(userId);
        return devices.stream()
                .map(this::mapToDto)
                .toList();
    }

    private DeviceDto mapToDto(Device device) {
        return DeviceDto.builder()
                .id(device.getId())
                .name(device.getName())
                .type(device.getType())
                .location(device.getLocation())
                .userId(device.getUserId())
                .build();
    }
}
