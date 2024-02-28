package com.vehicle_department.service.vehicle.mapper;

import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import com.vehicle_department.model.vehicle.domain.Vehicle;
import com.vehicle_department.service.vehicle.dto.VehicleDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VehicleMapperTest {
    private Vehicle vehicle;
    private VehicleDto vehicleDto;

    @Autowired
    private VehicleMapper vehicleMapper;

    @BeforeEach()
    void initialize() {
        vehicle = Vehicle.builder()
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

        vehicleDto = VehicleDto.builder()
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

    @Test
    @DisplayName("Testing mapToVehicle(VehicleDto vehicleDto) method.")
    public void givenVehicleDtoObject_whenMapToVehicle_thenReturnVehicleObject() {
        // given
        // when
        Vehicle testVehicle = vehicleMapper.mapToVehicle(vehicleDto);

        // then
        assertAll(
                () -> assertNotNull(testVehicle),
                () -> assertEquals(1L, testVehicle.getId()),
                () -> assertEquals("registration 1", testVehicle.getRegistrationNumber()),
                () -> assertEquals("vin 1", testVehicle.getVehicleIdentificationNumber()),
                () -> assertEquals("manufacturer", testVehicle.getManufacturer()),
                () -> assertEquals("model", testVehicle.getModel()),
                () -> assertEquals("1111", testVehicle.getProductionYear()),
                () -> assertEquals(11.11, testVehicle.getMileage()),
                () -> assertEquals(EngineType.DIESEL, testVehicle.getEngineType()),
                () -> assertEquals(GearboxType.MANUAL, testVehicle.getGearboxType()),
                () -> assertEquals("none1", testVehicle.getAdditionalInformation())
        );
    }

    @Test
    @DisplayName("Testing mapToVehicleDto(Vehicle vehicle) method.")
    public void givenVehicleObject_whenMapToVehicleDto_thenReturnVehicleDtoObject() {
        // given
        // when
        VehicleDto testVehicle = vehicleMapper.mapToVehicleDto(vehicle);

        // then
        assertAll(
                () -> assertNotNull(testVehicle),
                () -> assertEquals(1L, testVehicle.getId()),
                () -> assertEquals("registration 1", testVehicle.getRegistrationNumber()),
                () -> assertEquals("vin 1", testVehicle.getVehicleIdentificationNumber()),
                () -> assertEquals("manufacturer", testVehicle.getManufacturer()),
                () -> assertEquals("model", testVehicle.getModel()),
                () -> assertEquals("1111", testVehicle.getProductionYear()),
                () -> assertEquals(11.11, testVehicle.getMileage()),
                () -> assertEquals(EngineType.DIESEL, testVehicle.getEngineType()),
                () -> assertEquals(GearboxType.MANUAL, testVehicle.getGearboxType()),
                () -> assertEquals("none1", testVehicle.getAdditionalInformation())
        );
    }

}
