package com.example.jobPortal.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum WorkMode {
    WORK_FROM_OFFICE("Work from Office"),
    HYBRID("Hybrid"),
    REMOTE("Remote");
    private final String label;

    WorkMode(String label) {
        this.label = label;
    }
    @JsonValue//needed for deserialization
    public String getLabel() {
        return label;
    }
}
