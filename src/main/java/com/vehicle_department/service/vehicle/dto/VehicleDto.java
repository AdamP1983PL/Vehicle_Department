package com.vehicle_department.service.vehicle.dto;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDto {

    private Long id;
    @Size(min = 3, max = 12)
    @NotEmpty(message = "Registration number should not be empty.")
    private String registrationNumber;
    @Size(min = 3, max = 17)
    @NotEmpty(message = "VIN number should not be empty.")
    private String vehicleIdentificationNumber;
    @NotEmpty(message = "Manufacturer should not be empty. Optionally: type \"unknown\".")
    private String manufacturer;
    @NotEmpty(message = "Model should not be empty. Optionally: type \"unknown\".")
    private String model;
    private String productionYear;
    @Min(0)
    private double mileage;
    private EngineType engineType;
    private GearboxType gearboxType;
    @Size(max = 255)
    private String additionalInformation;

}

// todo add swagger documentation
