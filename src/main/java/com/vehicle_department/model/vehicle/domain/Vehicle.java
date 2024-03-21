package com.vehicle_department.model.vehicle.domain;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import lombok.Builder;

import javax.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private EngineType engineType;

    @Column(name = "GEARBOX_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private GearboxType gearboxType;

    @Column(name = "ADDITIONAL_INFO")
    private String additionalInformation;

    public Vehicle() {
    }

    public Vehicle(Long id,
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
        return "Vehicle{" +
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
