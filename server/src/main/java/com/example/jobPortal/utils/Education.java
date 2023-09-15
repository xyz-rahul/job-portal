package com.example.jobPortal.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Education {
    HIGH_SCHOOL("High School"),
    BACHELOR("Bachelor's Degree"),
    MASTER("Master's Degree"),
    PHD("PhD"),
    OTHER("Other");

    private final String label;

    Education(String label) {
        this.label = label;
    }

    @JsonValue//needed for deserialization
    public String getLabel() {
        return label;
    }
}
