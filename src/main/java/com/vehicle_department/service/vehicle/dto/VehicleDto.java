package com.vehicle_department.service.vehicle.dto;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import lombok.Builder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    @Enumerated(EnumType.STRING)
    private EngineType engineType;
    @Enumerated(EnumType.STRING)
    private GearboxType gearboxType;
    @Size(max = 255)
    private String additionalInformation;

    public VehicleDto() {
    }

    public VehicleDto(Long id,
                      String registrationNumber,
                      String vehicleIdentificationNumber,
                      String manufacturer,
                      String model,
                      String productionYear,
                      double mileage,
                      EngineType engineType,
                      GearboxType gearboxType,
                      String additionalInformation) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.productionYear = productionYear;
        this.mileage = mileage;
        this.engineType = engineType;
        this.gearboxType = gearboxType;
        this.additionalInformation = additionalInformation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(String productionYear) {
        this.productionYear = productionYear;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
                "id=" + id +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", vehicleIdentificationNumber='" + vehicleIdentificationNumber + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", productionYear='" + productionYear + '\'' +
                ", mileage=" + mileage +
                ", engineType=" + engineType +
                ", gearboxType=" + gearboxType +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}

// todo add swagger documentation
