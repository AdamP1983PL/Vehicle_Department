package com.vehicle_department.service.vehicle;

import com.vehicle_department.exceptions.ResourceNotFoundException;
import com.vehicle_department.model.enums.EngineType;
import com.vehicle_department.model.enums.GearboxType;
import com.vehicle_department.model.vehicle.domain.Vehicle;
import com.vehicle_department.model.vehicle.repository.VehicleRepository;
import com.vehicle_department.service.vehicle.dto.VehicleDto;
import com.vehicle_department.service.vehicle.mapper.VehicleMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleServiceImplTest {
    private Vehicle vehicle1;
    private Vehicle vehicle2;
    private Vehicle updatedVehicle1;
    private VehicleDto vehicleDto1;
    private VehicleDto vehicleDto2;
    private VehicleDto updatedVehicleDto1;

    @BeforeEach()
    void initialize() {
        vehicle1 = Vehicle.builder()
                .id(1L)
                .registrationNumber("registration 1")
                .vehicleIdentificationNumber("vin 1")
                .manufacturer("manufacturer1")
                .model("model1")
                .productionYear("1111")
                .mileage(11.11)
                .engineType(EngineType.DIESEL)
                .gearboxType(GearboxType.MANUAL)
                .additionalInformation("none1")
                .build();

        vehicle2 = Vehicle.builder()
                .id(2L)
                .registrationNumber("registration 2")
                .vehicleIdentificationNumber("vin 2")
                .manufacturer("manufacturer2")
                .model("model2")
                .productionYear("2222")
                .mileage(22.22)
                .engineType(EngineType.PETROL)
                .gearboxType(GearboxType.AUTOMATIC)
                .additionalInformation("test information")
                .build();

        vehicleDto1 = VehicleDto.builder()
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

        vehicleDto2 = VehicleDto.builder()
                .id(2L)
                .registrationNumber("registration 2")
                .vehicleIdentificationNumber("vin 2")
                .manufacturer("manufacturer2")
                .model("model2")
                .productionYear("2222")
                .mileage(22.22)
                .engineType(EngineType.PETROL)
                .gearboxType(GearboxType.AUTOMATIC)
                .additionalInformation("test information")
                .build();

        updatedVehicle1 = Vehicle.builder()
                .id(1L)
                .registrationNumber("registration")
                .vehicleIdentificationNumber("updated vin 1")
                .manufacturer("updated manufacturer1")
                .model("updated model1")
                .productionYear("updated 1111")
                .mileage(11.11)
                .engineType(EngineType.DIESEL)
                .gearboxType(GearboxType.MANUAL)
                .additionalInformation("updated none1")
                .build();

        updatedVehicleDto1 = VehicleDto.builder()
                .id(1L)
                .registrationNumber("registration")
                .vehicleIdentificationNumber("updated vin 1")
                .manufacturer("updated manufacturer1")
                .model("updated model1")
                .productionYear("updated 1111")
                .mileage(11.11)
                .engineType(EngineType.DIESEL)
                .gearboxType(GearboxType.MANUAL)
                .additionalInformation("updated none1")
                .build();

    }

    @AfterEach
    void cleanUp() {
        vehicleRepository.deleteAll();
    }

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private VehicleMapper vehicleMapper;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImpl;

    @Test
    @DisplayName("Testing findAllVehicles() method - negative scenario (empty list).")
    public void givenEmptyVehiclesList_whenFindAllVehicles_thenReturnEmptyVehicleDtoList() {
        // given
        given(vehicleRepository.findAll()).willReturn(Collections.emptyList());

        // when
        List<VehicleDto> vehicles = vehicleServiceImpl.findAllVehicles();

        // then
        assertTrue(vehicles.isEmpty());
    }

    @Test
    @DisplayName("Testing findAllVehicles() method - positive scenario (valid input).")
    public void givenVehiclesList_whenFindAllVehicles_thenReturnVehicleDtoList() {
        // given
        given(vehicleRepository.findAll()).willReturn(List.of(vehicle1, vehicle2));
        given(vehicleMapper.mapToVehicleDto(vehicle1)).willReturn(vehicleDto1);
        given(vehicleMapper.mapToVehicleDto(vehicle2)).willReturn(vehicleDto2);

        // when
        List<VehicleDto> vehicles = vehicleServiceImpl.findAllVehicles();

        // then
        assertAll(
                () -> assertNotNull(vehicles),
                () -> assertTrue(vehicles.size() == 2),
                () -> assertEquals(vehicleDto1, vehicles.get(0)),
                () -> assertEquals(vehicleDto2, vehicles.get(1)),
                () -> assertEquals("registration 1", vehicles.get(0).getRegistrationNumber())
        );
    }

    @Test
    @DisplayName("Testing findVehicleByVIN(String vin) method - positive scenario (valid input).")
    public void givenVehicleVINNumber_whenFindVehicleByVIN_thenReturnVehicleDtoObject() {
        // given
        String vin = "vin 1";
        given(vehicleRepository.findVehicleByVehicleIdentificationNumber(vin)).willReturn(Optional.ofNullable(vehicle1));
        given(vehicleMapper.mapToVehicleDto(vehicle1)).willReturn(vehicleDto1);

        // when
        VehicleDto testVehicle = vehicleServiceImpl.findVehicleByVIN(vin);

        // then
        assertAll(
                () -> assertNotNull(testVehicle),
                () -> assertEquals(vehicleDto1, testVehicle),
                () -> assertEquals("vin 1", testVehicle.getVehicleIdentificationNumber()),
                () -> assertEquals(EngineType.DIESEL, testVehicle.getEngineType())
        );
    }

    @Test
    @DisplayName("Testing findVehicleByVIN(String vin) method that throws ResourceNotFoundException.")
    public void givenVINNumber_whenFindVehicleByVIN_thenThrowsResourceNotFoundException() {
        // given
        String vin = "none";
        given(vehicleRepository.findVehicleByVehicleIdentificationNumber(vin)).willReturn(Optional.empty());

        // when, then
        assertThrows(ResourceNotFoundException.class, () -> {
            vehicleServiceImpl.findVehicleByVIN(vin);
        });
        verify(vehicleRepository, times(1)).findVehicleByVehicleIdentificationNumber(vin);
        verify(vehicleMapper, never()).mapToVehicleDto(any());
    }

    @Test
    @DisplayName("Testing findVehicleByRegistrationNumber(String regNum) method - positive scenario.")
    public void givenRegistrationNumber_whenFindVehicleByRegistrationNumber_thenReturnVehicleDtoObject() {
        // given
        String registrationNumber = "registration 1";
        given(vehicleRepository.findVehicleByRegistrationNumber(registrationNumber))
                .willReturn(Optional.ofNullable(vehicle1));
        given(vehicleMapper.mapToVehicleDto(vehicle1)).willReturn(vehicleDto1);

        // when
        VehicleDto testVehicle = vehicleServiceImpl.findVehicleByRegistrationNumber(registrationNumber);

        // then
        assertAll(
                () -> assertNotNull(testVehicle),
                () -> assertEquals(vehicleDto1, testVehicle),
                () -> assertEquals(1L, testVehicle.getId())
        );
    }

    @Test
    @DisplayName("Testing findVehicleByRegistrationNumber(String regNum) method that throws RNFException ")
    public void givenRegistrationNumber_whenFindVehicleByRegistrationNumber_thenThrowsResourceNotFoundException() {
        // given
        String registrationNumber = "none";
        given(vehicleRepository.findVehicleByRegistrationNumber(registrationNumber))
                .willReturn(Optional.empty());

        // when, then
        assertThrows(ResourceNotFoundException.class, () -> {
            vehicleServiceImpl.findVehicleByRegistrationNumber(registrationNumber);
        });
        verify(vehicleRepository, times(1)).findVehicleByRegistrationNumber(registrationNumber);
        verify(vehicleMapper, never()).mapToVehicleDto(any());
    }

    @Test
    @DisplayName("Testing createVehicle(VehicleDto vehicleDto) method.")
    public void givenVehicleDtoObject_whenCreateVehicle_thenReturnCreatedVehicleDtoObject() {
        // given
        given(vehicleRepository.findVehicleByRegistrationNumber(vehicleDto1.getRegistrationNumber()))
                .willReturn(Optional.empty());
        given(vehicleRepository.findVehicleByVehicleIdentificationNumber(vehicleDto1.getVehicleIdentificationNumber()))
                .willReturn(Optional.empty());
        given(vehicleRepository.save(vehicle1)).willReturn(vehicle1);
        given(vehicleMapper.mapToVehicleDto(vehicle1)).willReturn(vehicleDto1);
        given(vehicleMapper.mapToVehicle(vehicleDto1)).willReturn(vehicle1);

        // when
        VehicleDto createdVehicle = vehicleServiceImpl.createVehicle(vehicleDto1);

        // then
        assertAll(
                () -> assertNotNull(createdVehicle),
                () -> assertEquals(1L, createdVehicle.getId()),
                () -> assertEquals("1111", createdVehicle.getProductionYear())
        );
    }

    @Test
    @DisplayName("Testing updateVehicle(VehicleDto vehicleDto, String registrationNumber) method.")
    public void givenVehicleObject_whenUpdateVehicle_thenReturnUpdatedVehicleObject() {
        // given
        given(vehicleRepository.findVehicleByRegistrationNumber(vehicleDto1.getRegistrationNumber()))
                .willReturn(Optional.ofNullable(vehicle1));
        given(vehicleRepository.save(vehicle1)).willReturn(updatedVehicle1);
        given(vehicleMapper.mapToVehicleDto(updatedVehicle1)).willReturn(updatedVehicleDto1);

        // when
        VehicleDto updatedVehicle = vehicleServiceImpl.updateVehicle(vehicleDto1, vehicleDto1.getRegistrationNumber());

        // then
        assertAll(
                () -> assertNotNull(updatedVehicle),
                () -> assertEquals("updated vin 1", updatedVehicle.getVehicleIdentificationNumber()),
                () -> assertEquals("updated manufacturer1", updatedVehicle.getManufacturer()),
                () -> assertEquals("updated 1111", updatedVehicle.getProductionYear())
        );
    }

    @Test
    @DisplayName("Testing deleteVehicleByRegistrationNumber(String registrationNumber) method.")
    public void givenRegistrationNumber_whenDeleteVehicleByRegistrationNumber_thenVehicleDeleted() {
        // given
        given(vehicleRepository.findVehicleByRegistrationNumber(vehicleDto1.getRegistrationNumber()))
                .willReturn(Optional.ofNullable(vehicle1));

        // when
        vehicleServiceImpl.deleteVehicleByRegistrationNumber(vehicleDto1.getRegistrationNumber());

        // then
        verify(vehicleRepository, times(1))
                .findVehicleByRegistrationNumber(vehicleDto1.getRegistrationNumber());
        verify(vehicleRepository, times(1)).delete(any(Vehicle.class));
    }

}
