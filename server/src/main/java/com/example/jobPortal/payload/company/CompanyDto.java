package com.example.jobPortal.payload.company;

import com.example.jobPortal.utils.CompanyType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public class CompanyDto {
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

    @JsonProperty("company_type")
    private CompanyType companyType;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Customize date format
    private Date createdAt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") // Customize date format
    private Date updatedAt;
}
