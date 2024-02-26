package com.vehicle_department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
public class VehicleDepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleDepartmentApplication.class, args);
    }

}
