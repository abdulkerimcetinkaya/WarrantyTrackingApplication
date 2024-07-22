package dev.kerim.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
public class Warranty extends BaseEntity{

    private long deviceId;

    @Temporal(TemporalType.DATE)
    private LocalDate purchaseDate;

    private String warrantyStatus;

}
