package com.vehicle_department.model.vehicle.domain;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "VEHICLES")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REGISTRATION_NO", nullable = false)
    private String registrationNumber;

    @Column(name = "VIN", nullable = false)
    private String vehicleIdentificationNumber;

    @Column(nullable = false)
    private String manufacturer;

    private String model;

    @Column(name = "PRODUCTION_YEAR", nullable = false)
    private String productionYear;

    @Column(nullable = false)
    private double mileage;

    @Column(name = "ENGINE_TYPE", nullable = false)
    private EngineType engineType;

    @Column(name = "GEARBOX_TYPE", nullable = false)
    private GearboxType gearboxType;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInformation;

}
