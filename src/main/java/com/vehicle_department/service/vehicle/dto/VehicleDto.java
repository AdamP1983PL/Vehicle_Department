package com.vehicle_department.service.vehicle.dto;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDto {

    private Long id;
    private String registrationNumber;
    private String vehicleIdentificationNumber;
    private String manufacturer;
    private String model;
    private String productionYear;
    private double mileage;
    private EngineType engineType;
    private GearboxType gearboxType;
    private String additionalInformation;

}
