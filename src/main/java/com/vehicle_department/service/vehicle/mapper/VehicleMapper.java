package com.vehicle_department.service.vehicle.mapper;

import com.vehicle_department.model.vehicle.domain.Vehicle;
import com.vehicle_department.service.vehicle.dto.VehicleDto;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public Vehicle mapToVehicle(VehicleDto vehicleDto) {
        return Vehicle.builder()
                .id(vehicleDto.getId())
                .registrationNumber(vehicleDto.getRegistrationNumber())
                .vehicleIdentificationNumber(vehicleDto.getVehicleIdentificationNumber())
                .manufacturer(vehicleDto.getManufacturer())
                .model(vehicleDto.getModel())
                .productionYear(vehicleDto.getProductionYear())
                .mileage(vehicleDto.getMileage())
                .engineType(vehicleDto.getEngineType())
                .gearboxType(vehicleDto.getGearboxType())
                .additionalInformation(vehicleDto.getAdditionalInformation())
                .build();
    }

    public VehicleDto mapToVehicleDto(Vehicle vehicle) {
        return VehicleDto.builder()
                .id(vehicle.getId())
                .registrationNumber(vehicle.getRegistrationNumber())
                .vehicleIdentificationNumber(vehicle.getVehicleIdentificationNumber())
                .manufacturer(vehicle.getManufacturer())
                .model(vehicle.getModel())
                .productionYear(vehicle.getProductionYear())
                .mileage(vehicle.getMileage())
                .engineType(vehicle.getEngineType())
                .gearboxType(vehicle.getGearboxType())
                .additionalInformation(vehicle.getAdditionalInformation())
                .build();
    }

}
