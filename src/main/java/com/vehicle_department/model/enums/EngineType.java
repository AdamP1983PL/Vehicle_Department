package com.vehicle_department.model.enums;

import lombok.Getter;

@Getter
public enum EngineType {
    UNKNOWN("UNKNOWN"),
    DIESEL("DIESEL"),
    PETROL("PETROL"),
    HYBRID("HYBRID"),
    ELECTRIC("ELECTRIC");

    private final String displayText;

    EngineType(String displayText) {
        this.displayText = displayText;
    }

}
