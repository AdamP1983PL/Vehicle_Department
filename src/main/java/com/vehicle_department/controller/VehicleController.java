package com.vehicle_department.controller;

import com.vehicle_department.service.vehicle.VehicleServiceImpl;
import com.vehicle_department.service.vehicle.dto.VehicleDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class VehicleController {

    private VehicleServiceImpl vehicleServiceImpl;

    @GetMapping("/api/vehicle/")
    public ResponseEntity<List<VehicleDto>> findAllVehicles() {
        List<VehicleDto> vehicleDtoList = vehicleServiceImpl.findAllVehicles();
        log.info("====>>>> findAllVehicles() execution");
        return new ResponseEntity<>(vehicleDtoList, HttpStatus.OK);
    }

    @GetMapping("/api/vehicle/vin/{vin}")
    public ResponseEntity<VehicleDto> findVehicleByVIN(@PathVariable("vin") String vin) {
        VehicleDto vehicleDto = vehicleServiceImpl.findVehicleByVIN(vin);
        log.info("====>>>> findVehicleByVIN(" + vin + ") execution.");
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @GetMapping("/api/vehicle/reg-num/{number}")
    public ResponseEntity<VehicleDto> findVehicleByRegistrationNumber(@PathVariable("number") String number) {
        VehicleDto vehicleDto = vehicleServiceImpl.findVehicleByRegistrationNumber(number);
        log.info("====>>>> findVehicleByRegistrationNumber(" + number + ") execution.");
        return new ResponseEntity<>(vehicleDto, HttpStatus.OK);
    }

    @PostMapping("/api/vehicle/")
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto) {
        VehicleDto createdVehicleDto = vehicleServiceImpl.createVehicle(vehicleDto);
        log.info("====>>>> createVehicle() execution.");
        return new ResponseEntity<>(createdVehicleDto, HttpStatus.CREATED);
    }

    @PutMapping("/api/vehicle/{number}")
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto,
                                                    @PathVariable("number") String number) {
        VehicleDto updatedVehicleDto = vehicleServiceImpl.updateVehicle(vehicleDto, number);
        log.info("====>>>> updateVehicle(" + number + ") execution.");
        return new ResponseEntity<>(updatedVehicleDto, HttpStatus.OK);
    }

    @DeleteMapping("/api/vehicle/{number}")
    public ResponseEntity<Void> deleteVehicleByRegistrationNumber(@PathVariable("number") String number) {
        vehicleServiceImpl.deleteVehicleByRegistrationNumber(number);
        log.info("====>>>> deleteVehicleByRegistrationNumber(" + number + ") execution.");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
