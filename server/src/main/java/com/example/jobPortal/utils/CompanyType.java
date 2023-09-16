package com.example.jobPortal.utils;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CompanyType {
    STARTUP("Startup"),
    SMALL("Small Company"),
    MEDIUM("Medium-sized Company"),
    LARGE("Large Company"),
    CORPORATION("Corporation");

    private final String label;

    CompanyType(String label) {
    this.label = label;
    }

    @JsonValue//needed for deserialization
    public String getLabel() {
        return label;
    }
}
