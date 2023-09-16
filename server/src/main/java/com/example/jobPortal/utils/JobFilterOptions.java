package com.example.jobPortal.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
public class JobFilterOptions {

    private Option<WorkMode> workMode = new Option<>("Work Mode", WorkMode.values());

    private Option<CompanyType> companyType = new Option<>("Company Type", CompanyType.values());

    private Option<Industry> industry = new Option<>("Industry", Industry.values());

    private Option<Education> education = new Option<>("Education", Education.values());

    private class Option<T> {
        @JsonProperty("title")
        private String title;
        @JsonProperty("values")
        private T[] values;

        Option(String title, T[] values) {
            this.title = title;
            this.values = values;
        }
    }

    // Getter and setter methods for the fields if needed
}
