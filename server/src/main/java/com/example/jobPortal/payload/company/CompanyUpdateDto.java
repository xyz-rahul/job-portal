package com.example.jobPortal.payload.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyUpdateDto {
    private Integer id;

    private String name;

    @JsonProperty(value = "phone_number")
    private String phoneNumber;

    @URL
    private String website;

    @Email
    private String email;

    private List<String> locations;

    private List<String> products;

    private String description;
}
