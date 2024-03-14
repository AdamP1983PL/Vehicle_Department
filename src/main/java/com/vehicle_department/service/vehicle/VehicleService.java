package com.vehicle_department.service.vehicle;

import com.vehicle_department.service.vehicle.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    List<VehicleDto> findAllVehicles();

    VehicleDto findVehicleByVIN(String vin);

    VehicleDto findVehicleByRegistrationNumber(String registrationNumber);

    VehicleDto createVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(VehicleDto vehicleDto, String registrationNumber);

    void mvcUpdateVehicle(VehicleDto vehicleDto);

    void deleteVehicleByRegistrationNumber(String registrationNumber);

}


