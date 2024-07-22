package dev.kerim.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Getter
@Setter

public class Device extends BaseEntity {

    private int serialNumber;
    private String brand;
    private String model;

}
