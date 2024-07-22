package dev.kerim.repository;

import dev.kerim.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDeviceRepository extends JpaRepository<Device, Long> {
}