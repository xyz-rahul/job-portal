package com.example.jobPortal.entity;

import com.example.jobPortal.utils.CompanyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.URL;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @URL
    private String website;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @ElementCollection
    @CollectionTable(name = "company_location", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "location")
    private List<String> locations;


    @ElementCollection
    @CollectionTable(name = "company_products", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "product")
    private List<String> products;

    @Column(length = 5000)
    private String description;

    @OneToMany(mappedBy = "company")
    private List<Job> jobList = new ArrayList<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;
}
