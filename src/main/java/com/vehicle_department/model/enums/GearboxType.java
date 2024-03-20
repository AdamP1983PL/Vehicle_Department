package com.vehicle_department.model.enums;


public enum GearboxType {
    UNKNOWN("UNKNOWN"),
    MANUAL("MANUAL"),
    SEMI_AUTOMATIC("SEMI_AUTOMATIC"),
    AUTOMATIC("AUTOMATIC");

    private final String displayText;

    GearboxType(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

}
