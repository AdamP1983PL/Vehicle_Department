package com.vehicle_department.model.vehicle.repository;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import com.vehicle_department.model.vehicle.domain.Vehicle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleRepositoryTest {
    private Vehicle vehicle1;

    @Autowired
    private VehicleRepository vehicleRepository;

    @BeforeEach()
    void initialise() {
        vehicle1 = Vehicle.builder()
                .id(1L)
                .registrationNumber("registration 1")
                .vehicleIdentificationNumber("vin 1")
                .manufacturer("manufacturer")
                .model("model")
                .productionYear("1111")
                .mileage(11.11)
                .engineType(EngineType.DIESEL)
                .gearboxType(GearboxType.MANUAL)
                .additionalInformation("none1")
                .build();
    }

    @AfterEach()
    void cleanUp() {
        vehicleRepository.deleteAll();
    }

    @Test
    @DisplayName("Testing findVehicleByVehicleIdentificationNumber(String vin) method.")
    public void givenVinNumber_whenFindVehicleByVehicleIdentificationNumber_thenReturnVehicleObject() {
        // given
        String vin = vehicle1.getVehicleIdentificationNumber();
        vehicleRepository.save(vehicle1);

        // when
        Optional<Vehicle> testVehicle = vehicleRepository.findVehicleByVehicleIdentificationNumber(vin);

        // then
        assertAll(
                () -> assertNotNull(testVehicle),
                () -> assertEquals("registration 1", testVehicle.get().getRegistrationNumber())
        );
    }

    @Test
    @DisplayName("Testing findVehicleByRegistrationNumber(String registrationNumber) method.")
    public void givenRegistrationNumber_whenFindVehicleByRegistrationNumber_thenReturnVehicleObject() {
        // given
        String registrationNumber = vehicle1.getRegistrationNumber();
        vehicleRepository.save(vehicle1);

        // when
        Optional<Vehicle> testVehicle = vehicleRepository.findVehicleByRegistrationNumber(registrationNumber);

        // then
        assertAll(
                () -> assertNotNull(testVehicle),
                () -> assertEquals("vin 1", testVehicle.get().getVehicleIdentificationNumber())
        );
    }

    // todo YAGNI?
    @Test
    void findVehicleByManufacturerAndModelOrderByManufacturerAscModelAsc() {
    }

}
