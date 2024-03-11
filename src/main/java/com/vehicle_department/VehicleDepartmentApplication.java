package com.vehicle_department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:database.properties")
//Registering VehicleDepartment Service as a Eureka Client with the Eureka Server
@EnableEurekaClient
public class VehicleDepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehicleDepartmentApplication.class, args);
    }

}


