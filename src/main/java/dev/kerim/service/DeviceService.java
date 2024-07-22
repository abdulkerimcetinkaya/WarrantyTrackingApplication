package dev.kerim.service;

import dev.kerim.entities.Device;
import dev.kerim.repository.IDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final IDeviceRepository iDeviceRepository;

    public Device saveDevice(Device device) {
        return iDeviceRepository.save(device);
    }

    public Device updateDevice(Device device) {
        return iDeviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        iDeviceRepository.deleteById(id);
    }

    public List<Device> getAllDevices() {
        return iDeviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return iDeviceRepository.findById(id).orElse(null);
    }
}
