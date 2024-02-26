package com.vehicle_department.model.vehicle.repository;

import com.vehicle_department.model.vehicle.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
