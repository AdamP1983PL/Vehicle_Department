package com.vehicle_department.controller;

import com.vehicle_department.service.vehicle.VehicleServiceImpl;
import com.vehicle_department.service.vehicle.dto.VehicleDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/api/vehicle/frontend")
public class VehicleThymeleafController {

    private VehicleServiceImpl vehicleServiceImpl;

    @GetMapping("/home")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/")
    public String listAllVehicles(Model model) {
        List<VehicleDto> vehicleDtoList = vehicleServiceImpl.findAllVehicles();
        model.addAttribute("vehicleDtoList", vehicleDtoList);
        log.info("====>>>> listAllVehicles() execution");
        return "vehicle-list";
    }

    @GetMapping("/add-vehicle")
    public String addVehicle(Model model) {
        VehicleDto vehicleDto = new VehicleDto();
        model.addAttribute("vehicleDto", vehicleDto);
        log.info("====>>>> addVehicle() execution");
        return "add-new-vehicle";
    }

    @PostMapping("/save-new-vehicle")
    public String saveNewVehicle(@Valid @ModelAttribute("vehicleDto") VehicleDto vehicleDto,
                                 BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("vehicleDto", vehicleDto);
            return "add-new-vehicle";
        }

        vehicleServiceImpl.createVehicle(vehicleDto);
        log.info("====>>>> saveNewVehicle() execution");
        return "redirect:/api/vehicle/frontend/";
    }

    @GetMapping("/details/registration/{registration}")
    public String listVehicleDetails(@PathVariable("registration") String registration, Model model) {
        VehicleDto vehicleDetails = vehicleServiceImpl.findVehicleByRegistrationNumber(registration);
        model.addAttribute("vehicleDetails", vehicleDetails);
        log.info("====>>>> listVehicleDetails() execution");
        return "vehicle-details";
    }

    @GetMapping("/edit/{registration}")
    public String editVehicle(@PathVariable("registration") String registration, Model model) {
        VehicleDto vehicleDto = vehicleServiceImpl.findVehicleByRegistrationNumber(registration);
        model.addAttribute("vehicleDto", vehicleDto);
        log.info("====>>>> editVehicle() execution");
        return "edit-vehicle";
    }

    @PostMapping("/update/{registration}")
    public String updateVehicle(@PathVariable("registration") String registration,
                                @Valid @ModelAttribute("vehicleDto") VehicleDto vehicleDto,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vehicleDto", vehicleDto);
            return "edit-vehicle";
        }
        vehicleDto.setRegistrationNumber(registration);
        vehicleServiceImpl.mvcUpdateVehicle(vehicleDto);
        log.info("====>>>> updateVehicle() execution");
        return "redirect:/api/vehicle/frontend/";
    }

}
